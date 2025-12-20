package programmers.lv1.solved.low;

public class 삼총사포문 {
    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        System.out.println(solution(number));

    }

    private static int solution(int[] number) {

        int count = 0;
        int sum = 0;

        for (int i = 0; i < number.length - 2; i++) {
            sum += number[i];
            for (int j = i + 1; j < number.length - 1; j++) {
                sum += number[j];
                for (int k = j + 1; k < number.length; k++) {
                    sum += number[k];
                    System.out.println("sum = " + sum + " i = " + i + " j = " + j + " k = " + k);
                }
            }
        }
        return count;
    }
}
