package lecture.dfs;

import java.util.*;

public class 수열추측하기 {
    private static int totalNum;
    private static boolean[] visited;
    private static boolean found;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        totalNum = sc.nextInt();


        visited = new boolean[N];

        dfs(N, "");


    }

    private static void dfs(int n, String str) {

        if(found) return;

        if(str.length() == n) {
            if(checkSet(str)) {
                String ans = "";
                for(int i = 0; i < str.length(); i++) {
                    ans += str.charAt(i) + " ";
                }
                System.out.println(ans.trim());
                found = true;
            }
            return;
        } else {
            for(int i = 1; i <= n; i++) {
                if(!visited[i-1]) {
                    visited[i-1] = true;
                    dfs(n, str + i);
                    visited[i-1] = false;
                }
            }
        }
    }

    private static boolean checkSet(String str) {

        String[] tokens = str.split("");
        int[] arr = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        int len = tokens.length;

        while (len > 1) {
            for(int i = 0; i < len-1; i++) {
                arr[i] = arr[i] + arr[i+1];
            }
            len--;
        }

        return arr[0] == totalNum;
    }
}


































