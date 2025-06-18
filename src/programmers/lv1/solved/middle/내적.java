package programmers.lv1.solved.middle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class 내적 {
    public static void main(String[] args) {

        int[] arr = {1,1,3,3,0,1,1};

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(arr[0]);

        for(int i=1; i<arr.length; i++){
            if(stack.peekLast() == arr[i]){
                continue;
            }
            stack.addLast(arr[i]);
        }

        System.out.println(stack);
        System.out.println(stack.size());

        for(int i = 0; i < stack.size(); i++) {
            System.out.println(stack.pollFirst());
        }


    }
}
