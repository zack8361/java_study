package lecture.dfs;

import java.util.Arrays;

public class 피보나치수열 {

    private static int[] dp;
    public static void main(String[] args) {
        int N = 45;

        dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 1;

        System.out.println(dfsFibo(N));

    }

    private static int dfsFibo(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = dfsFibo(n - 1) + dfsFibo(n - 2);
    }
}
