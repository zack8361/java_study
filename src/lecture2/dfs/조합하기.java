package lecture2.dfs;

public class 조합하기 {
    private static int count = 0;
    public static void main(String[] args) {
        int N = 33;
        int M = 19;

        dfs(N,M, 0, "", 1);
        System.out.println(count);
    }

    private static void dfs(int n, int m, int depth, String str, int start) {
        if(depth == m) {
            count++;
            return;
        }
        for (int i = start; i<=n; i++) {
            dfs(n, m, depth+1, str + i, i+1);
        }
    }
}