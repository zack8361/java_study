package lecture.dfs;

import java.util.Scanner;

public class 동전교환강사버전 {

    private static int maxCoin;
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        maxCoin = sc.nextInt();
        dfs(0,0,arr);

    }

    private static void dfs(int idx, int sum, int[] arr) {

        if(sum > maxCoin) {
            return;
        }
        if(sum == maxCoin) {
            answer = Math.min(answer, idx);
        } else {
            for(int i = 0; i < arr.length; i++) {

            }
        }
    }
}
