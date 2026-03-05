package lecture2.dfs;

import java.util.*;

// [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
public class 여행경로 {
    private static List<String> list;
    private static boolean[] visited;
    public static void main(String[] args) {

        String [][] tickets = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"},
        };
        visited = new boolean[tickets.length];
        list = new ArrayList<>();

        dfs(0,tickets,"ICN","ICN");
        Collections.sort(list);
//        return  list.get(0).split(" ");
    }

    private static void dfs(int depth, String[][] tickets, String str, String now) {
        if(depth == tickets.length) {
            list.add(str);
            return;
        }
        for(int i= 0; i <tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                dfs(depth+1,tickets,str +"  " +tickets[i][1], tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}