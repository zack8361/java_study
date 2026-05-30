import java.sql.SQLOutput;
import java.util.*;

static class Edge {
    int to;
    int cost;

    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    public String toString() {
        return this.to + " " + this.cost;
    }
}

static class Node implements Comparable<Node> {
    int vertex;
    int cost;

    Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }

    public String toString() {
        return this.vertex + " " + this.cost;
    }
}

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

    for (int i = 1; i <= n; i++) {
        graph.put(i, new ArrayList<>());
    }

    for (int[] edge : edges) {
        int from = edge[0];
        int to = edge[1];
        int cost = edge[2];

        graph.get(from).add(new Edge(to, cost));
    }
    System.out.println(graph);

    int result = dijkstra(graph, start, end, n);
    System.out.println("최단거리: " + result);
}

static int dijkstra(Map<Integer, List<Edge>> graph, int start, int end, int n) {
    int INF = Integer.MAX_VALUE;
    int[] distance = new int[n + 1];
    Arrays.fill(distance, INF);

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));
    distance[start] = 0;

    while (!pq.isEmpty()) {
        Node current = pq.poll();
        System.out.println(current.toString());
        System.out.println(Arrays.toString(distance));

        int now = current.vertex;
        int nowCost = current.cost;
        if (distance[now] < nowCost) {
            continue;
        }


        for (Edge next : graph.get(now)) {
            int newCost = nowCost + next.cost;

            if (newCost < distance[next.to]) {
                distance[next.to] = newCost;
                pq.offer(new Node(next.to, newCost));
            }
        }
    }

    return distance[end];
}
