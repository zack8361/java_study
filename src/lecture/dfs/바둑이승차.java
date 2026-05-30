package lecture.dfs;

import java.util.Scanner;

public class 바둑이승차 {
    private static int N;
    private static int MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        MAX_VALUE = Integer.MIN_VALUE;
        int M = sc.nextInt();

        int[] arr = new int[M];

        for(int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0,0,arr);
        System.out.println(MAX_VALUE);
    }

    private static void dfs(int sum, int idx, int[] arr) {
        if(idx == arr.length) {
            if(sum <= N) {
                MAX_VALUE = Math.max(MAX_VALUE, sum);
            }
        } else {
            dfs(sum+arr[idx],idx+1,arr);
            dfs(sum,idx+1,arr);
        }
    }
}
