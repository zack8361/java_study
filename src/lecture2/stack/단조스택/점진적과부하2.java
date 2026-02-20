package lecture2.stack.단조스택;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 점진적과부하2 {
    public static void main(String[] args) {
        int[] weights = {25, 23, 31, 28, 25, 25, 27, 29};
        int[] answer = new int[weights.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < weights.length; i++) {
            int now = weights[i];

            while (!stack.isEmpty() && weights[stack.peekLast()] < now) {
                Integer pop = stack.pollLast();
                answer[pop] = i - pop;
            }
            stack.addLast(i);
        }

        System.out.println(Arrays.toString(answer));



//        System.out.println(stack);
//        System.out.println(Arrays.toString(answer));

    }
}
