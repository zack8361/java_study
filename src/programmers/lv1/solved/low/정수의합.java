package programmers.lv1.solved.low;

public class 정수의합 {
    public static void main(String[] args) {
        System.out.println(solution(3,5));
    }
    private static int solution(int a, int b) {

        int sum = 0;
        for(int i= Math.min(a,b); i<=Math.max(a,b); i++){
            sum += i;
        }

        return sum;
    }
}
