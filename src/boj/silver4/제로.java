package boj.silver4;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class 제로 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            if(num == 0) {
                stack.pollLast();
            } else {
                stack.addLast(num);
            }
        }
        int sum = 0;

        for (Integer i : stack) {
            sum +=i;
        }
        System.out.println(sum);

    }
}
