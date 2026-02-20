package lecture2.dfs;

import java.util.ArrayList;

public class 상태공간트리 {
    public static void main(String[] args) {
        int[] nums = {4,9,7,5,1};
        int target = 15;
        int m = 3;

        boolean dfs = dfs(nums, target, m, new ArrayList<>(), 0);
        if(dfs){
            System.out.println("찾음");
        }else {
            System.out.println("못찾음");
        }

    }

    private static boolean dfs(int[] nums, int target, int m, ArrayList<Integer> list, int start) {
        System.out.println(list);
        if(list.size() == 3) {
            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            return target == sum;
        }

        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums,target, m, list, i+1);
            list.remove(list.size()-1);
        }

        return false;

    }
}
