package lecture2.stack.단조스택;

import java.util.*;
public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < prices.length; i++) {
            int now = prices[i];
            while(!deque.isEmpty() && prices[deque.peekLast()] > now) {
                Integer i1 = deque.pollLast();
                answer[i1] = i - i1;
            }
            deque.addLast(i);
        }

        for(int i = 0; i < answer.length; i++) {
            if(answer[i] == 0) {
                answer[i] = answer.length - i - 1;
            }
        }
    }
}
