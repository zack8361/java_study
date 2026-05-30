package lecture2.topologicalSort;

import java.util.*;

public class 위상정렬예시탬플릿 {
    public static void main(String[] args) {
        int nodesNum = 6;
        int[][] edges = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2},
                {4, 3},
                {5, 3}
        };

        System.out.println(topologicalSort(nodesNum, edges));
    }

    private static int topologicalSort(int nodesNum, int[][] edges) {
        int answer = 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[nodesNum];

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            graph.putIfAbsent(end, new ArrayList<>());
            graph.get(end).add(start);

            indegree[start]++;
        }

        int[] arr = new int [2];

        System.out.println(graph);


        return answer;
    }
}
