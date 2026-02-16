package lecture.twoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class 겹치는건싫어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] count = new int[arr.length];

        int left = 0;
        int right = 0;
        int answer = 0;

        while(right < arr.length) {
            count[arr[right]]++;

            while(count[arr[right]] > k) {
                count[arr[left]]--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
            right++;
        }
        System.out.println(Arrays.toString(count));

    }
}
