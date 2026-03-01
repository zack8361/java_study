
package lecture2.dfs;

public class N과M1 {
    public static void main(String[] args) {
        int N = 4;
        dfs( N,"");
    }

    private static void dfs(int N, String str) {
        System.out.println(str);
        if(str.length() == N) return;

        for(int i= 1; i <= N; i++) {
            dfs(N, str + i);
        }
    }
}