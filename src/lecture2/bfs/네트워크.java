package lecture2.bfs;

import java.util.ArrayDeque;

public class 네트워크 {

    private static boolean[] visited;
    public static void main(String[] args) {

        int N = 3;
        int[][] network = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        visited = new boolean[N];
        int cnt = 0;

        for(int i = 0; i < network.length; i++) {
            if(!visited[i]) {
                bfs(network, i);
                cnt ++;
            }
        }
        System.out.println(cnt);

    }

    private static void bfs(int[][] network, int start) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.addLast(start);
        visited[start] = true;

        while (!deque.isEmpty()) {
            int next = deque.pollFirst();

            for(int i = 0; i < network.length; i++) {
                if(network[next][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    deque.addLast(i);
                }
            }
        }



    }
}
