package programmers.greedy.단조스택;

import java.util.ArrayDeque;

public class 큰수만들기 {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        System.out.println(Solution(number,k));
    }

    private static String Solution(String number, int k) {
        ArrayDeque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < number.length(); i++) {
            char now = number.charAt(i);

            while (!deque.isEmpty() && k >0 && deque.peekLast() <now) {
                deque.pollLast();
                k--;
            }
            deque.addLast(now);
        }

        while (k > 0) {
            deque.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : deque) {
            sb.append(c);
        }
        return sb.toString();
    }
}
