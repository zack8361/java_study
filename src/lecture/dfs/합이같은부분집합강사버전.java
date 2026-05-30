package lecture.dfs;

import java.util.Scanner;

public class 합이같은부분집합강사버전 {
    private static int total = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        if(dfs(0, arr,0)) {
            System.out.println("YES");
        };


    }

    private static boolean dfs(int idx, int[] arr, int sum) {

        if(idx == arr.length) {
            if(total-sum == sum) {
                return true;
            }
        } else {
            dfs(idx + 1, arr, sum + arr[idx]);
            dfs(idx + 1, arr, sum);
        }


        return false;
    }
}