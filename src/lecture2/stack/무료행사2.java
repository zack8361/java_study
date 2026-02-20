package lecture2.stack;

import java.util.HashSet;
import java.util.Set;

public class 무료행사2 {
    public static void main(String[] args) {
        int[] prices = {4, 1, 9, 7, 5, 3, 16};
        int target = 14;

         int answer = 0;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < prices.length; i++) {
            if(set.contains(target - prices[i])){
                answer ++;
                continue;
            }
            set.add(prices[i]);
        }
        System.out.println(answer);
    }
}
