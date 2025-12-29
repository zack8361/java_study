package programmers.lv1.solved.low;

import java.util.HashSet;
import java.util.Set;

public class 옹알이 {
    private static HashSet<String> set = new HashSet<>();
    private static boolean visited[];
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        System.out.println(solution(babbling));
    }

    private static int solution(String[] babbling) {

        String[] bs = {"aya", "ye", "woo", "ma"};
        visited = new boolean[babbling.length];
        makeDfs(bs,"");

        int count = 0;
        for (String s : set) {
            for (String b : babbling) {
                if(s.equals(b)) {
                    count++;
                }
            }
        }

        return count;

    }

    private static void makeDfs(String[] babbling, String s) {
        set.add(s);

        for(int i=0; i<babbling.length; i++){
            if(!visited[i]){
                visited[i] = true;
                makeDfs(babbling, s+babbling[i]);
                visited[i] = false;
            }
        }
    }
}
