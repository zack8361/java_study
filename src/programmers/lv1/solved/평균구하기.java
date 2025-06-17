package programmers.lv1.solved;

public class 평균구하기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
    }

    private static double solution(int[] arr) {

        double sum = 0;

        for(int i : arr) {
            sum += i;
        }

        return sum / arr.length;
    }
}
