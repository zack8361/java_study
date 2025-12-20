package testExample;

import java.util.Arrays;

public class WhileExample {
    public static void main(String[] args) {
        int[] arr = {0,1,0,0};
        int index = 2;
        int left = index-1;
        int right = index+1;

        while (left>=0 && right<arr.length&& arr[left] == arr[right]) {
            arr[left] = 1;
            arr[right] = 1;
            left--;
            right++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
