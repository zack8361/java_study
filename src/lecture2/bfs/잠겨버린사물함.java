package lecture2.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 잠겨버린사물함 {
    private static boolean[] visited;
    public static void main(String[] args) {
        int[][] lockers = {
                {1,2},
                {3},
                {},
                {0}
        };
        visited = new boolean[lockers.length];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            System.out.println(Arrays.toString(visited));
            Integer cur = queue.remove();

            visited[cur] = true;
            for(int i: lockers[cur]) {
                if(!visited[i]) {
                    queue.add(i);
                }
            }
        }

    }
}
