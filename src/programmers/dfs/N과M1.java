package programmers.dfs;

public class N과M1 {
    private static int n = 3;
    private static int ans = 1;

    public static void main(String[] args) {
        dfs(0, "");
    }

    private static void dfs(int depth, String str) {
        if(depth == ans) {
            System.out.println(str);
            return;
        }

        for(int i=0; i<n; i++){
            dfs(depth+1,str + (i+1));
        }
    }
}
