package lecture2.Dijkstra;

import java.util.*;

public class DijkstraExample3 {
    private static int[] distance;
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

        Map<Integer, List<Edge>> graph = new HashMap<>();

        for(int i = 1; i <=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.get(from).add(new Edge(to,weight));
        }

        distance = new int[n+1];
        Arrays.fill(distance, 100);

        int result = dijkstra(8, 1, 8, graph);
        System.out.println(result);
    }

    private static int dijkstra(int n, int start, int end, Map<Integer, List<Edge>> graph) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));


        distance[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int nowNode = node.node;
            int nowWeight = node.weightSum;

            if(distance[nowNode] < nowWeight) continue;


            for(Edge nextNode: graph.get(nowNode)) {
                int nextWeight = nowWeight + nextNode.weight;
                if(nextWeight < distance[nextNode.to]) {
                    distance[nextNode.to] = nextWeight;
                    pq.offer(new Node(nextNode.to, nextWeight));
                }
            }

        }

        return distance[end];
    }

    private static class Node implements Comparable<Node>{
        int node;
        int weightSum;
        public Node(int node, int weightSum) {
            this.node = node;
            this.weightSum = weightSum;
        }
        public String toString() {
            return node + "," +  weightSum;
        }

        @Override
        public int compareTo(Node otherNode) {
            return this.weightSum - otherNode.weightSum;
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
