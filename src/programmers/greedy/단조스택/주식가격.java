package programmers.greedy.단조스택;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        System.out.println(solution(prices));
    }

    private static int[] solution(int[] prices) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length-1; i++) {
            answer[i] = prices.length-i-1;
        }

        for(int i = 0; i < prices.length; i++) {
            int now = prices[i];

            while (!deque.isEmpty() && prices[deque.peekLast()] > now) {
                Integer pop = deque.pollLast();
                answer[pop] = i - pop;
            }

            deque.addLast(i);
        }

        return answer;
    }
}
