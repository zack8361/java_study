package boj.gold4;

import java.util.ArrayDeque;
import java.util.Scanner;

public class 문자열폭발 {
    private static final String EXPLODE = "FRULA";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> deque = new ArrayDeque<>();
        String word = sc.next();
        String bomb = sc.next();


        for(int i=0; i<word.length(); i++){
            String letter = String.valueOf(word.charAt(i));
            deque.addLast(letter);
            if(deque.size() >= bomb.length()){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<bomb.length() ; j++){
                    sb.append(deque.pollLast());
                }
                String check = sb.reverse().toString();
                if(check.equals(bomb)){
                    continue;
                } else {
                    for(int j=0; j<bomb.length() ; j++){
                        deque.addLast(String.valueOf(check.charAt(j)));
                    }
                }
            }
        }
        if(deque.isEmpty()) {
            System.out.println(EXPLODE);
            return;
        }
        System.out.println(String.join("", deque));
    }
}
