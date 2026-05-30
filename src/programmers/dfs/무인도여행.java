package programmers.dfs;

import kotlin.reflect.KVisibility;

import java.util.*;

public class 무인도여행 {
    private static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static String[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        String[] maps = {
                "X591X",
                "X1X5X",
                "X231X",
                "1XXX1"
        };

        createMap(maps);

        int count = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(!visited[i][j]) {
                    list.add(bfs(map, i,j));
                }
            }
        }

        System.out.println(list);
    }

    private static int bfs(String[][] map,int x, int y) {
        visited[x][y] = true;
        Deque<Node> deque = new ArrayDeque<>();

        deque.addLast(new Node(x, y));
        int count = 0;
        while(!deque.isEmpty()) {
            Node node = deque.pollFirst();
            count += Integer.parseInt(map[node.x][node.y]);

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || ny > 0  || nx >= map.length || ny >= map[0].length) {
                    continue;
                }
                if(!visited[nx][ny]) {
                    deque.addLast(new Node(nx, ny));
                }
            }
        }

        return count;
    }

    private static void createMap(String[] maps) {
        map = new String[maps.length][maps[0].length()];
        visited= new boolean[maps.length][maps[0].length()];

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                map[i][j] = String.valueOf(maps[i].charAt(j));
                if(map[i][j].equals("X")) {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        for(int i = 0; i < maps.length; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
    }
}
