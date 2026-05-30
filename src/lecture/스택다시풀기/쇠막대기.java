package lecture.스택다시풀기;

import java.util.ArrayDeque;
import java.util.Deque;

public class 쇠막대기 {
    public static void main(String[] args) {
        String s = "()(((()())(())()))(())";

        Deque<Character> deque = new ArrayDeque<>();

        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                deque.push(s.charAt(i));
            } else {
                if(i != 0 && s.charAt(i-1) == '(') {

                } else {

                }
            }
        }

    }
}
