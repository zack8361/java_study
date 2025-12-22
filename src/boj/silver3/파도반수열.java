package boj.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class 파도반수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4; i<=100; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        int N = sc.nextInt();
        for(int i = 0; i< N; i++){
            int num = sc.nextInt();
            System.out.println(dp[num]);
        }

    }
}
