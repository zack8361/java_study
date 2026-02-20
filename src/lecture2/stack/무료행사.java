package lecture2.stack;

import java.util.Arrays;

public class 무료행사 {
    public static void main(String[] args) {
        int[] prices = {4, 1, 9, 7, 5, 3, 16};
        int target = 14;

        Arrays.sort(prices);
        int lt = 0, rt = prices.length - 1;

        int answer = 0;
        while (lt < rt) {
            if(prices[lt] + prices[rt] > target){
                rt --;
            } else if(prices[lt] + prices[rt] < target){
                lt ++;
            } else {
                answer ++;
                lt ++;
            }
        }
        System.out.println(answer);
    }
}
