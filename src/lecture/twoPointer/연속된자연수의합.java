package lecture.twoPointer;

import java.util.Arrays;

public class 연속된자연수의합 {
    public static void main(String[] args) {
        int n = 15;
        int answer =0;
        int left = 0;
        int right = 0;
        int sum = 0;

        int[] arr = new int[n/2+1];
        for (int i = 1; i <= n/2+1; i++) {
            arr[i - 1] = i;
        }

        System.out.println(Arrays.toString(arr));

        while (right < arr.length) {
            sum += arr[right];

            while (sum > n) {
                sum -= arr[left++];
            }

            if (sum == n) {
                answer++;
            }
            right++;
        }
        System.out.println(answer);
    }
}
