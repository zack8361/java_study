package lecture2.dfs.이분그래프;

import java.util.Arrays;

public class 홍팀청팀 {
    private static int[] color;
    public static void main(String[] args) {
        int[][] friends = {
                {1, 2},
                {0, 3},
                {0},
                {1}
        };
        color = new int[friends.length];
        Arrays.fill(color, -1);

        for(int i = 0; i < friends.length; i++) {
            if(color[i] == -1) {
                color[i] = 0;
                boolean isTeam = dfs(i, friends);
                if(!isTeam) System.out.println("잘못됌"); return;
            }
        }

    }

    private static boolean dfs(int cur, int[][] friends) {
        for(int nxt: friends[cur]) {
            if(color[nxt] == color[cur]) return false;
            if(color[nxt] == -1) {
                color[nxt] = 1- color[cur];
                if(!dfs(nxt, friends)) return false;
            }
        }
        return true;
    }
}
