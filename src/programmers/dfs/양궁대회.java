package programmers.dfs;

import java.util.Arrays;
import java.util.HashMap;

//5	[2,1,1,1,0,0,0,0,0,0,0]
public class 양궁대회 {
    private static HashMap<Integer, Integer> scoreMap;
    private static int MAX = Integer.MIN_VALUE;
    private static int[] info;
    private static int[] answer;

    public static void main(String[] args) {
        int n = 1;
        info = new int[]{1,0,0,0,0,0,0,0,0,0,0};
        scoreMap = new HashMap<>();
        answer = new int[info.length];

        int[] map = new int[info.length];

        for(int i = 0; i <= 10; i++) {
            scoreMap.put(i, 10-i);
        }

        dfs(map, n,0,0);


    }

    private static void dfs(int[] map, int n, int depth, int start) {
        if (depth == n) {
            int diff = compare(map);
            if(MAX < diff) {
                answer = map.clone();
                System.out.println(Arrays.toString(answer));
                MAX = diff;
            } else if (MAX == diff) {
                if(isBetter(answer, map)) {
                    answer = map.clone();
                }
            }
            return;
        }

        for (int i = start; i < 11; i++) {
            map[i]++;
            dfs(map, n, depth + 1, i);
            map[i]--;
        }
    }

    private static boolean isBetter(int[] answer, int[] map) {

        for(int i = map.length-1; i >= 0; i--) {
            if(answer[i] > map[i]) {
                return true;
            } else if( answer[i] < map[i]) {
                return false;
            }
        }
        return false;
    }

    private static int compare(int[] map) {
        int apache = 0;
        int lyon = 0;

        for(int i = 0; i < map.length; i++) {
            if(info[i] == 0 && map[i] == 0) continue;
            if(info[i] >= map[i]) {
                apache += scoreMap.get(i);
            } else {
                lyon += scoreMap.get(i);
            }
        }

        if(lyon > apache) {
            return lyon - apache;
        }

        return 0;
    }
}
