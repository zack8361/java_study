package lecture.bfs;

import java.util.ArrayDeque;

public class 송아지찾기 {
    private static int[] distance = {5, 1,-1};
    private static boolean[] visited;
    public static void main(String[] args) {
        int N = 5;
        int target = 14;
        visited = new boolean[10001];
        int[] dis = new int[10001];

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(N);
        visited[N] = true;

        while (!deque.isEmpty()) {
            Integer nowNode = deque.pollFirst();

            if(nowNode == target) {
                System.out.println(dis[nowNode]);
                break;
            }
            for(int i = 0; i < distance.length; i++) {
                int nextNode = nowNode + distance[i];
                if(nextNode < 0 || nextNode >= 10000 || visited[nextNode]) {
                    continue;
                }
                deque.addLast(nextNode);
                visited[nextNode] = true;
                dis[nextNode] = dis[nowNode] + 1;
            }
        }
    }
}
