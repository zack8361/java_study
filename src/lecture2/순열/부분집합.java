package lecture2.순열;

import java.util.ArrayList;
import java.util.List;

public class 부분집합 {
    private static List<List<Integer>> answer = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        dfs(nums, 0, new ArrayList<Integer>()) ;
        System.out.println(answer);
    }

    private static void dfs(int[] nums, int start,  ArrayList<Integer> list) {
        answer.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size()-1);
        }

    }
}
