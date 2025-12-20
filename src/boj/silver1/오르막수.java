package boj.silver1;

import java.util.Arrays;
import java.util.Scanner;

public class 오르막수 {

    private static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[N+1][10];

        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

    }
}
