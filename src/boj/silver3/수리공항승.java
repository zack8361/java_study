package boj.silver3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class 수리공항승 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(arr[0]);
        int point = arr[0];
        int count = 1;

        for(int i = 1; i< arr.length; i++){
            if(arr[i] - point < L) {
                deque.addLast(arr[i]);
            } else {
                deque.addLast(arr[i]);
                point = arr[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
