package programmers.lv2;

import javax.swing.plaf.IconUIResource;
import java.util.Map;

public class 피로도 {
    private static boolean[] visited;
    private static int answer;
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        visited = new boolean[dungeons.length];
        dfs(k,dungeons, 0);
        System.out.println(answer);
    }

    private static void dfs(int k, int[][] dungeons, int count) {

        answer = Math.max(answer, count);

        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }

    }
}
