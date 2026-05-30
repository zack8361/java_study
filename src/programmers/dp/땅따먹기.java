package programmers.dp;

// [[1,2,3,5],[5,6,7,8],[4,3,2,1]]
public class 땅따먹기 {
    private static int[] dp;
    private static boolean[] visited;

    public static void main(String[] args) {
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 5, 2, 1}}
                ;

        int answer = 0;

        visited = new boolean[4];
        dfs(land, 0, 0);

    }

    private static void dfs(int[][] land, int sum, int depth) {



        for(int i = 0; i < 4; i++) {
            dfs(land, sum + i, depth + 1);
        }
    }
}
