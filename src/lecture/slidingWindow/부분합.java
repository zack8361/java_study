package lecture.slidingWindow;

import java.util.Scanner;

public class 부분합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int cnt = 0;
        int cntAns = Integer.MAX_VALUE;

        int answer = 0;

        while(right < n) {
            answer += arr[right];

            while(answer >= m) {
                cntAns = Math.min(cntAns, right - left + 1);
                answer -= arr[left++];
            }
            right++;
        }
        if(cntAns == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(cntAns);
        }
    }
}