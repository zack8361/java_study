package programmers.lv1.solved.low;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 햄버거만들기 {
    private static final String BURGER = "1231";
    public static void main(String[] args) {
         int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient));
    }

    private static int solution(int[] ingredient) {

        int top = 0;
        int count = 0;
        int[] stack = new int[ingredient.length];

        for(int x: ingredient) {
            stack[top++] = x;
            if(top >=4) {
                if(stack[top-4] == 1 && stack [top-3] == 2 && stack [top-2] == 3 && stack [top-1] ==1) {
                    top -=4;
                    count ++;
                }
            }
        }
        return count;
    }
}
