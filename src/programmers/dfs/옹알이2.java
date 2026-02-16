package programmers.dfs;

import java.util.HashSet;
import java.util.Set;

public class 옹알이2 {

    private static Set<String> set;
    public static void main(String[] args) {
        String[] babbling = {"aya", "ye", "woo", "ma"};

        System.out.println(solution(babbling));
    }

    private static int solution(String[] babbling) {
        int answer = 0;

        set = new HashSet<>();
        dfs(babbling, "", 0, "");

        for (String s : set) {

        }

        return answer;
    }

    private static void dfs(String[] babbling, String str, int now, String nowStr) {

        set.add(str);
        if (now == 4) return;
        for (int i = 0; i < babbling.length; i++) {
            if (nowStr.equals(babbling[i])) continue;
            dfs(babbling, str + babbling[i], now + 1, babbling[i]);
        }
    }
}
