package programmers.lv1.solved.low;

public class 나머지가1이되는수 {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    private static int solution(int n) {

        for(int i = 2; i<n; i++) {
            if(n%i == 1) {
                return i;
            }
        }
        return 0;
    }

}
