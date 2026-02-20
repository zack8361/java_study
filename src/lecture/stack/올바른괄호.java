package lecture.stack;


import java.util.Stack;

// 입력된 문자열에서 소괄호 () 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램 작성
public class 올바른괄호 {
    public static void main(String[] args) {
        String s = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }
        System.out.println(stack);

    }
}
