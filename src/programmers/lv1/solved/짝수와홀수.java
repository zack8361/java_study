package programmers.lv1.solved;

public class 짝수와홀수 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    private static String solution(int n) {
        if(n%2 ==0) {
            return "Even";
        } else {
            return "Odd";
        }
    }
}
