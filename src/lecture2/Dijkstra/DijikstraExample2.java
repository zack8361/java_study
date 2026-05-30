package lecture2.Dijkstra;

import java.util.*;

public class DijikstraExample2 {

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2, 2},
                {1, 4, 1},
                {2, 3, 1},
                {2, 5, 2},
                {2, 6, 4},
                {3, 6, 4},
                {4, 3, 3},
                {4, 7, 5},
                {6, 5, 3},
                {7, 6, 7},
                {7, 8, 6},
                {5, 8, 1}
        };

        int n = 8;
        int start = 1;
        int end = 8;

        Map<Integer, List<Edge>>  graph = new HashMap<>();

        for(int i = 0; i < end; i++) {
            graph.put(i, new ArrayList<>());
        }

        System.out.println(graph);

        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.get(from).add(new Edge(to, weight));
        }
        System.out.println(graph);
        int result = djikstra(graph, start, end, n);

        System.out.println(result);
    }

    private static int djikstra(Map<Integer, List<Edge>> graph, int start, int end, int n) {
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int now = current.vertex; // 몇번 노드
            int nowWeight = current.weight; // 까지 갈 수 있는 비용.

            if(distance[now] < nowWeight) {
                continue;
            }

            for(Edge next: graph.get(now)) {
                int newWeight = nowWeight + next.weight;

                if(newWeight < distance[next.to]) {
                    distance[next.to] = newWeight;
                    pq.offer(new Node(next.to, newWeight));
                }
            }
        }

        return -1;
    }

    private static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Node other) {
            return this.weight - other.weight;
        }

        public String toString() {
            return this.vertex + " " + this.weight;
        }
    }

    private static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        public String toString() {
            return "(" + to + ", " + weight + ")";
        }
    }
}
