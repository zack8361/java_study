package boj.silver3;

import java.util.Scanner;

public class 더하기123 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            int[] dp = new int[M+1];

            dp[0] = 1; // 0을 만드는 방법은 아무것도 안 쓰는 1가지
            dp[1] = 1; // 1 = (1)
            dp[2] = 2; // 2 = (1+1), (2)
            dp[3] = 4; // 3 = (1+1+1), (1+2), (2+1), (3)

            for (int j = 4; j <= M; i++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
        }
    }
}
