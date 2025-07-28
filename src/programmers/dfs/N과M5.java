package programmers.dfs;

import java.util.Arrays;

public class N과M5 {
    private static String[] arr = {"9","8","7","1"};
    private static boolean[] visited = new boolean[arr.length];
    private static int m = 2;

    public static void main(String[] args) {
        Arrays.sort(arr);
        dfs(0,"");
    }

    private static void dfs(int depth, String str) {

        if(depth == m) {
            System.out.println(str);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, str + arr[i]);
                visited[i] = false;
            }
        }
    }
}
