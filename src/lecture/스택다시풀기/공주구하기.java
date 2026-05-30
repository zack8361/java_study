package lecture.스택다시풀기;

import java.util.ArrayDeque;
import java.util.Scanner;

public class 공주구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i<=n; i++){
            deque.addLast(i);
        }

        while (deque.size() > 1){
            for(int i = 0; i < m-1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();
        }

        System.out.println(deque.pollFirst());

    }
}
