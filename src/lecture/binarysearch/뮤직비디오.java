package lecture.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

// 9 3
//1 2 3 4 5 6 7 8 9

public class 뮤직비디오 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        int sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }


        int left = arr[arr.length-1];
        int right = sum;

        while (left <= right) {
            int mid = (left + right) / 2;

            int arrSum = 0;
            int cnt = 1;

            for(int i = 0; i < N; i++) {
                arrSum += arr[i];
                if(arrSum > mid) {
                    arrSum -= arr[i];
                    cnt ++;
                    arrSum = arr[i];
                }
            }
             if(cnt > M) {
                left = mid + 1;
            } else {
                right = mid -1;
                 System.out.println(mid);
            }
        }
    }
}
