package lecture2.stack.단조스택;

import java.util.Arrays;

public class 점진적과부하 {
    public static void main(String[] args) {
        int[] weights = {25, 23, 31, 28, 25, 25, 27, 29};
        int[] answer = new int[weights.length];

        for(int i = 0; i < weights.length; i++) {
            int now = weights[i];
            for (int j = i + 1; j < weights.length; j++) {
                int tomorrow = weights[j];
                if (tomorrow > now) {
                    answer[i] = j-i;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(answer));

    }
}
