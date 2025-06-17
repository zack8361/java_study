package programmers.lv1.solved.low;

public class 약수의합 {
    public static void main(String[] args) {
        System.out.println(solution(12));
    }

    private static int solution(int n) {

        int total = 0;

        for (int i = 1; i <= n; i++) {
            if(n%i == 0) {
                total +=i;
            }
        }
        return total;
    }
}
