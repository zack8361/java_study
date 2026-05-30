package programmers.dfs;

import java.util.ArrayList;
import java.util.List;

public class 전력망둘로나누기V2 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    public static void main(String[] args) {
        int n = 9;

        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };

        createGraph(wires,n);
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            visited = new boolean[n+1];

            int count = dfs(1, a,b);
            int otherCount = n-count;

            System.out.println(Math.abs(count-otherCount));
        }
    }

    private static int dfs(int now, int a, int b) {
        visited[now] = true;

        int count = 1;

        for (int next : graph.get(now)) {
            if ((now == a && next == b) || (now == b && next == a)) {
                continue;
            }

            if (!visited[next]) {
                count += dfs(next, a, b);
            }
        }

        return count;
    }

    private static void createGraph(int[][] wires, int n) {

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < wires.length; i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }

        System.out.println(graph);
    }
}
