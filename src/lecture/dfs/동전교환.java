package lecture.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class 동전교환 {
    private static int MIN_COUNT;
    private static int totalMoney;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        totalMoney = sc.nextInt();
        MIN_COUNT = Integer.MAX_VALUE;
        dfs(arr, 0, 0, "");

        System.out.println(MIN_COUNT);
    }

    private static boolean dfs(int[] arr, int depth, int sum, String path) {

        if(sum >= totalMoney) {
            if(sum == totalMoney) {
                MIN_COUNT = Math.min(MIN_COUNT, depth);
                return true;
            }
            return false;
        }

        for(int i = arr.length-1; i >= 0; i--) {
            if(dfs(arr, depth + 1, sum + arr[i], path + arr[i])) {
                return true;
            };
        }
        return false;
    }
}








































