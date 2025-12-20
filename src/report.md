# Next-Search Platform 코드 리뷰 보고서

## 🔍 개요

본 보고서는 next-search 플랫폼의 DSL-to-Elasticsearch 쿼리 변환 시스템에 대한 종합적인 코드 리뷰 결과를 담고 있습니다. 특히 **중첩된 Bool 쿼리 구조** (`query > bool > filter > bool > should`)의 구현 한계와 개선 방안을 중심으로 분석하였습니다.

---

## 🏗️ 현재 아키텍처 분석

### 시스템 구조
- **헥사고날 아키텍처** 채택 (Domain → Application → Framework → Bootstrap)
- **gRPC 통신** 기반의 검색 서비스
- **Elasticsearch** 검색 엔진 연동
- **Kafka Streams** 기반 실시간 인덱싱

### 주요 컴포넌트
```
gRPC Request → SearchGrpcService → SearchInputPort → SearchOutputPort → SearchAdapter → QueryBuilder → Elasticsearch
```

---

## ⚠️ 현재 한계점 분석

### 1. 중첩된 Bool 쿼리 구조의 한계

#### **문제점:**
현재 구현은 **단일 레벨 불린 로직**만 지원하며, 복잡한 중첩 구조를 생성할 수 없습니다.

**현재 지원 구조:**
```json
{
  "bool": {
    "must": [...],
    "should": [...],
    "must_not": [...]
  }
}
```

**지원되지 않는 구조:**
```json
{
  "bool": {
    "filter": {
      "bool": {
        "should": [
          {"term": {"maker": "LG"}},
          {"term": {"maker": "Samsung"}}
        ]
      }
    },
    "must": [
      {"match": {"title": "monitor"}}
    ]
  }
}
```

#### **코드상 한계 (`QueryBuilder.kt:74-111`):**
```kotlin
// 현재: 평면적 구조만 가능
val boolQuery: Query = QueryBuilders.bool { builder ->
    query.filter?.forEach { (fieldKey, fieldValue) ->
        // fieldValue.and/or/not은 단일 레벨에서만 작동
        fieldValue.and?.let { applyConditions(builder, fieldKey, boost, it, BoolQuery.Builder::must) }
        fieldValue.or?.let { applyConditions(builder, fieldKey, boost, it, BoolQuery.Builder::should) }
    }
}
```

### 2. DSL 구조의 제약사항

#### **Field 클래스 한계 (`Field.kt`):**
```kotlin
class Field(
    val and: List<Condition>? = null,    // 단순한 조건 리스트
    val or: List<Condition>? = null,
    val not: List<Condition>? = null,
)
// 문제: 중첩된 불린 그룹을 표현할 수 없음
```

#### **복잡한 로직 표현 불가:**
- `(A AND B) OR (C AND D)` 같은 그룹핑 불가능
- Filter context와 Query context 분리 불가능
- `minimum_should_match` 파라미터 지원 불가

### 3. 아키텍처 위반 사항

#### **헥사고날 아키텍처 위반:**
- **QueryBuilder**가 Framework 레이어에 있으나 비즈니스 로직 포함 (Application 레이어로 이동 필요)
- Domain 모델이 기술적 제약에 종속됨

#### **보안 취약점:**
- **쿼리 인젝션 위험**: 사용자 입력 검증 부재 (`QueryBuilder.kt:138-149`)
- **정보 노출**: 디버그 모드에서 민감한 정보 로깅 (`QueryBuilder.kt:58-60`)

---

## 🛠️ 개선 방안

### Phase 1: Enhanced DSL 설계

#### **1. 확장된 Domain 모델**

```kotlin
// 새로운 BooleanExpression 클래스
data class BooleanExpression(
    val must: List<QueryExpression>? = null,
    val should: List<QueryExpression>? = null,
    val mustNot: List<QueryExpression>? = null,
    val filter: List<QueryExpression>? = null,
    val minimumShouldMatch: Int? = null,
    val context: QueryContext = QueryContext.FILTER
)

// 재귀적 쿼리 표현
sealed class QueryExpression {
    data class TermExpression(val field: String, val value: String) : QueryExpression()
    data class TermsExpression(val field: String, val values: List<String>) : QueryExpression()
    data class RangeExpression(val field: String, val range: Range) : QueryExpression()
    data class BoolExpression(val boolQuery: BooleanExpression) : QueryExpression() // 재귀적 중첩
    data class NestedExpression(val path: String, val query: QueryExpression) : QueryExpression()
}

enum class QueryContext { FILTER, QUERY }
```

#### **2. 확장된 Field 클래스**

```kotlin
class Field(
    val and: List<Condition>? = null,
    val or: List<Condition>? = null,
    val not: List<Condition>? = null,
    // 새로운 필드들
    val context: QueryContext = QueryContext.FILTER,
    val nestedGroups: List<BooleanGroup>? = null,
    val minimumShouldMatch: Int? = null
)

data class BooleanGroup(
    val context: QueryContext = QueryContext.FILTER,
    val must: List<Condition>? = null,
    val should: List<Condition>? = null,
    val mustNot: List<Condition>? = null,
    val minimumShouldMatch: Int? = null,
    val nestedGroups: List<BooleanGroup>? = null  // 재귀적 중첩 지원
)
```

### Phase 2: 개선된 QueryBuilder 아키텍처

#### **1. Application 레이어로 이동**

```kotlin
// Application 레이어 - Use Case 인터페이스
interface QueryBuildingUseCase {
    fun <T : BaseQuery> buildSearchQuery(query: T): ElasticsearchQuery
}

// Application 레이어 - Port 인터페이스
interface QueryTransformationOutputPort {
    fun <T : BaseQuery> transformToElasticsearch(query: T): ElasticsearchQuery
}

// Framework 레이어 - Adapter 구현
@Component
class ElasticsearchQueryAdapter : QueryTransformationOutputPort {
    fun buildComplexBoolQuery(expression: BooleanExpression): Query {
        return QueryBuilders.bool { builder ->
            expression.must?.forEach { expr -> 
                builder.must(buildQueryExpression(expr)) 
            }
            expression.should?.forEach { expr -> 
                builder.should(buildQueryExpression(expr)) 
            }
            expression.filter?.forEach { expr -> 
                builder.filter(buildQueryExpression(expr)) 
            }
            expression.minimumShouldMatch?.let { 
                builder.minimumShouldMatch(it.toString()) 
            }
        }
    }
    
    // 재귀적 쿼리 표현식 빌딩
    private fun buildQueryExpression(expr: QueryExpression): Query {
        return when (expr) {
            is QueryExpression.TermExpression -> buildTermQuery(expr)
            is QueryExpression.TermsExpression -> buildTermsQuery(expr)
            is QueryExpression.RangeExpression -> buildRangeQuery(expr)
            is QueryExpression.BoolExpression -> buildComplexBoolQuery(expr.boolQuery) // 재귀 호출
            is QueryExpression.NestedExpression -> buildNestedQuery(expr)
        }
    }
}
```

#### **2. 보안 강화**

```kotlin
@Component
class QuerySecurityValidator {
    
    private val validFieldNamePattern = Regex("^[a-zA-Z0-9._-]+$")
    private val maxNestedDepth = 10
    
    fun validateQuery(query: BaseQuery) {
        validateFieldNames(query)
        validateNestedDepth(query)
        sanitizeUserInput(query)
    }
    
    private fun validateFieldName(fieldName: String) {
        if (!fieldName.matches(validFieldNamePattern)) {
            throw SearchException(ErrorCode.INVALID_FIELD_NAME_ERROR)
        }
    }
    
    private fun sanitizeValue(value: String): String {
        return value.replace(Regex("[^a-zA-Z0-9\\s.-]"), "")
    }
}
```

### Phase 3: Protocol Buffer 확장

#### **Proto 스키마 업데이트**

```protobuf
// search.proto 확장
message SearchField {
  repeated ConditionValue and = 1;
  repeated ConditionValue or = 2;
  repeated ConditionValue not = 3;
  
  // 새로운 필드들
  QueryContext context = 4;
  repeated BooleanGroup nested_groups = 5;
  optional int32 minimum_should_match = 6;
}

message BooleanGroup {
  QueryContext context = 1;
  repeated ConditionValue must = 2;
  repeated ConditionValue should = 3;
  repeated ConditionValue must_not = 4;
  optional int32 minimum_should_match = 5;
  repeated BooleanGroup nested_groups = 6;  // 재귀적 중첩
}

enum QueryContext {
  QUERY_CONTEXT_UNSPECIFIED = 0;
  FILTER = 1;
  QUERY = 2;
}
```

---

## 🚀 구현 로드맵

### **즉시 구현 (1-2주)**
1. **보안 취약점 수정**
   - 입력 검증 및 sanitization 구현
   - 민감한 정보 로깅 제거

2. **Field 클래스 확장**
   - BooleanGroup 지원 추가
   - 재귀적 중첩 구조 지원

3. **QueryBuilder 개선**
   - 재귀적 쿼리 빌딩 로직 구현
   - Context-aware 쿼리 생성

### **단기 구현 (3-4주)**
1. **아키텍처 재구성**
   - QueryBuilder를 Application 레이어로 이동
   - 적절한 Port/Adapter 패턴 적용

2. **Protocol Buffer 업데이트**
   - 중첩 구조 지원하는 스키마 설계
   - 클라이언트 호환성 유지

### **장기 구현 (2-3개월)**
1. **성능 최적화**
   - 쿼리 캐싱 시스템 구현
   - 복잡한 쿼리 분석 도구 개발

2. **모니터링 및 분석**
   - 쿼리 복잡도 분석기
   - 성능 메트릭 수집

---

## 📈 예상 효과

### **1. 쿼리 표현력 향상**
```json
// 개선 후 지원 가능한 복잡한 쿼리
{
  "bool": {
    "filter": [
      {
        "bool": {
          "should": [
            {"term": {"maker": "LG"}},
            {"term": {"maker": "Samsung"}}
          ],
          "minimum_should_match": 1
        }
      }
    ],
    "must": [
      {
        "bool": {
          "should": [
            {"match": {"title": "게이밍"}},
            {"match": {"title": "모니터"}}
          ]
        }
      }
    ]
  }
}
```

### **2. 성능 최적화**
- **Filter Context** 활용으로 캐싱 최적화
- **Query Context** 분리로 스코어링 효율성 증대
- 복잡한 쿼리의 Elasticsearch 네이티브 최적화 활용

### **3. 유지보수성 향상**
- 명확한 관심사 분리
- 테스트 가능한 구조
- 확장성 있는 DSL 설계

---

## ⚡ 긴급 조치 사항

### **1. 보안 패치 (즉시 적용 필요)**
```kotlin
// QueryBuilder.kt에 즉시 적용
private fun validateAndSanitizeInput(value: String): String {
    if (value.length > 1000) {
        throw SearchException(ErrorCode.INVALID_INPUT_LENGTH_ERROR)
    }
    return value.replace(Regex("[<>\"'&]"), "")
}
```

### **2. 로깅 보안 강화**
```kotlin
// 민감한 정보 마스킹
if (convertedQuery.debug) {
    logger.info { "Query executed for channel: ${convertedQuery.channel}" }
    // 전체 request 로깅 제거
}
```

---

## 🎯 결론 및 권고사항

### **핵심 권고사항:**
1. **즉시**: 보안 취약점 패치 적용
2. **단기**: 중첩 Bool 쿼리 지원을 위한 DSL 확장
3. **중기**: 헥사고날 아키텍처 준수를 위한 구조 개선
4. **장기**: 성능 최적화 및 모니터링 시스템 구축

### **우선순위:**
- 🔴 **P0**: 보안 취약점 수정
- 🟡 **P1**: 중첩 Bool 쿼리 지원
- 🟢 **P2**: 아키텍처 개선
- 🔵 **P3**: 성능 최적화

현재 플랫폼은 기본적인 검색 기능은 잘 구현되어 있으나, **복잡한 중첩 Bool 쿼리 지원**과 **보안 강화**가 시급히 필요합니다. 제안된 개선 방안을 단계적으로 적용하면 확장성과 안정성을 크게 향상시킬 수 있을 것입니다.

---

*보고서 작성일: 2025-07-29*  
*분석 대상: next-search 플랫폼 v1.0*  
*검토자: Claude Code + 전문 에이전트팀 (MCP, Backend, Search Engine, Code Review)*