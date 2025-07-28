package programmers.dfs;

public class N과M3 {

    private static int n = 4;
    private static int m = 2;
    private static boolean[] visited = new boolean[n];

    public static void main(String[] args) {
        dfs(0,"");
    }

    private static void dfs(int depth, String str){
        if(depth == m) {
            System.out.println(str);
            return;
        }
        for (int i = 1; i <=n; i++) {
            if(!visited[i-1]) {
                visited[i-1] = true;
                dfs(depth + 1, str + " " + i);
                visited[i-1] = false;
            }
        }
    }
}
