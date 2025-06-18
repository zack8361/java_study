package programmers.lv1.solved.middle;

public class 제곱근판별 {
    public static void main(String[] args) {
        System.out.println(solution(144));
    }

    private static boolean solution(int i) {

        double sqrt = Math.sqrt(i);
        if (sqrt == (int) sqrt) {
            return true;
        }


        return false;
    }
}
