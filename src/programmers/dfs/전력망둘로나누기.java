import java.util.*;

public class 전력망둘로나누기 {
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

        createGraph(n, wires);

        int answer = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int cutA = wire[0];
            int cutB = wire[1];

            visited = new boolean[n + 1];

            int count = dfs(1, cutA, cutB);
            int other = n - count;

            answer = Math.min(answer, Math.abs(count - other));
        }

        System.out.println(answer);
    }
//     int[][] wires = {
//                {1, 3},
//                {2, 3},
//                {3, 4},
//                {4, 5},
//                {4, 6},
//                {4, 7},
//                {7, 8},
//                {7, 9}
//        };

    private static int dfs(int now, int cutA, int cutB) {
        visited[now] = true;

        int count = 1;

        for (int next : graph.get(now)) {
            if ((now == cutA && next == cutB) || (now == cutB && next == cutA)) {
                continue;
            }

            if (!visited[next]) {
                count += dfs(next, cutA, cutB);
            }
        }

        return count;
    }

    private static void createGraph(int n, int[][] wires) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(graph);
    }
}