package boj.silver2;

import java.util.*;

public class 주식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int answer = 0;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            long sum = 0;
            int maxValue = Integer.MIN_VALUE;
            for(int j = arr.length-1; j >=0; j--){
                if(arr[j] > maxValue){
                    maxValue = arr[j];
                } else {
                    sum += (long)maxValue - arr[j];
                }
            }
            System.out.println(sum);
        }
    }
}
