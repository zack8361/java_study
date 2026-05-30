package lecture.스택다시풀기;

import java.util.ArrayDeque;

public class 교육과정설계 {
    public static void main(String[] args) {
        String priority = "AKDEF";
        String lecture = "AYKGDHEJ";


        ArrayDeque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < priority.length(); i++) {
            deque.addLast(priority.charAt(i));
        }

        String answer = "YES";

        for(char c : lecture.toCharArray()) {
            if(deque.contains(c)) {
                if(deque.peekFirst() == c) {
                    deque.pollFirst();
                } else {
                    answer = "NO";
                    break;
                }
            }
        }
        if(!deque.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);
    }
}
