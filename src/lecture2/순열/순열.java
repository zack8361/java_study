package lecture2.순열;

import java.util.ArrayList;
import java.util.List;

public class 순열 {

    private static List<List<Integer>> answer = new ArrayList<>();
    private static boolean[] visited;
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int m = 2;
        visited = new boolean[nums.length];
        dfs(m, nums, new ArrayList<>());
        System.out.println(answer);
    }

    private static void dfs(int m, int[] nums, ArrayList<Integer> list) {
        if(list.size() == m) {
            answer.add(new ArrayList<>(list));
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(m, nums, list);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }

    }
}
