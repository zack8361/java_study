package lecture.dfs;

import java.util.Scanner;

public class 최대점수구하기 {
    private static int limitTime;
    private static int MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        limitTime = sc.nextInt();
        MAX_VALUE = Integer.MIN_VALUE;
        int[][] arr = new int[N][2];

        for(int i=0;i<N;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        dfs(arr,0,0,0);
        System.out.println(MAX_VALUE);

    }

    private static void dfs(int[][] arr, int timeSum, int scoreSum, int idx) {
        if(idx == arr.length) {
            if(timeSum <= limitTime) {
                MAX_VALUE = Math.max(MAX_VALUE, scoreSum);
            }
        } else {
            dfs(arr, timeSum + arr[idx][1],  scoreSum + arr[idx][0], idx+1);
            dfs(arr, timeSum,  scoreSum, idx+1);
        }
    }
}
