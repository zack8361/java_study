package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    private static boolean[] visited;
    private static Set<Integer> set = new HashSet<>();;
    public static void main(String[] args) {
        String n = "17";
        System.out.println(solution(n));
    }

    private static int solution(String n) {
        int answer = 0;
        visited =new boolean[n.length()];
        dfs(n,"");

        System.out.println(set);

        for (Integer i : set) {
            if(i!=0 && i!=1 && isPrime(i)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isPrime(Integer number) {
        for(int i=2; i<number; i++) {
            if(number%i==0) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(String n, String str) {

        if(!str.isBlank()) set.add(Integer.parseInt(str));

        for(int i=0; i< n.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(n,str+n.charAt(i));
                visited[i] = false;
            }
        }
    }
}
