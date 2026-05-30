package lecture.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

// 5 3
//1 2 8 4 9

public class 마굿간구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N  = sc.nextInt();
        int M   = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);


        int left = 1;
        int right = arr[arr.length - 1] - arr[0];
        int answer = 0;

        while (left <= right) {

            System.out.println("left = " + left);
            System.out.println("right = " + right);
            int mid = (left + right) / 2;
            int cnt = 1;

            int value = arr[0];
            for(int i = 1; i < N; i++) {
                if(arr[i] - value >= mid) {
                    cnt ++;
                    value = arr[i];
                }
            }
            if(cnt >= M) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
