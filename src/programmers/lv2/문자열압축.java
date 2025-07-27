package programmers.lv2;

public class 문자열압축 {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int answer = Integer.MAX_VALUE; // 최댓값으로 초기화

        /**
         * 첫번째 for문 : 압축단위
         */
        for(int i=1; i<=s.length()/2; i++){
            StringBuilder sb= new StringBuilder();
            String prev = s.substring(0,i);
            int count = 1;

            for(int j=i; j<s.length(); j += i){
                String current = s.substring(j, Math.min(j + i, s.length()));
                if(prev.equals(current)){
                    count++;
                } else {
                    if(count>1) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    prev = current;
                    count = 1;
                }
            }
            if (count > 1) sb.append(count);
            sb.append(prev);
            answer = Math.min(answer,sb.length());
        }
        return answer;
    }
}
