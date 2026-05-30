package programmers.greedy.단조스택;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 뒤에있는큰수찾기 {
    public static void main(String[] args) {
        int[] numbers = {2,3,3,5};
        System.out.println(Solution(numbers));
    }

    private static int[] Solution(int[] numbers) {

        Deque<Integer> deque = new ArrayDeque<>();

        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        System.out.println(Arrays.toString(answer));

        for(int i = 0; i < numbers.length; i++) {
            int now = numbers[i];
            while (!deque.isEmpty() && numbers[deque.peekLast()] < now) {
                Integer pop = deque.pollLast();
                answer[pop] = numbers[i];
            }

            deque.addLast(i);

        }
        System.out.println(Arrays.toString(answer));


        return null;
    }
}
