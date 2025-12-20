package boj.silver1;

import java.util.Arrays;
import java.util.Scanner;

public class 랩레슨 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        int right = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            right += arr[i];
        }

        int left = arr[arr.length-1];

        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 1;
            int max = Integer.MIN_VALUE;

            for(int i=0; i<arr.length; i++) {
                sum += arr[i];
                if(sum >= mid) {
                    max = Math.max(max,sum);
                    sum = 0;
                    count ++;
                }
            }
            if(count > M) {
                left = mid + 1;
            } else{
                ans = mid;
                right = mid - 1;
            }
        }
    }
}
