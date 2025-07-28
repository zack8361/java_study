package programmers.dfs;

public class N과M2 {

    private static int n = 4;
    private static int m = 2;

    public static void main(String[] args) {
        dfs(0,0, "");
    }

    private static void dfs(int now ,int depth, String str) {
        if(depth == m) {
            System.out.println(str);
            return;
        }
        for (int i = now; i <n; i++) {
            dfs(i+1,depth+1, str + (i+1));
        }
    }
}
