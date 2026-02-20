package lecture2.dfs;

import java.util.Arrays;

public class 잠겨버린사물함 {
    private static boolean[] visited;
    public static void main(String[] args) {
        // 인접리스트 방식으로 이미 구현되어있음 -> 기본 DFS 문제.
        int[][] lockers = {
                {1,2},
                {3},
                {},
                {0}
        };

        visited = new boolean[lockers.length];
        System.out.println(Arrays.toString(visited));
        dfs(0,lockers);
        System.out.println(Arrays.toString(visited));

    }

    private static void dfs(int cur, int[][] lockers) {
        visited[cur] = true;

        for (int i : lockers[cur]) {
            if (!visited[i]) {
                dfs(i,lockers);
            }
        }
    }
}
