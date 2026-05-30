package lecture.투포인터다시풀기;

import java.util.Scanner;

public class 최대매출 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < M; i++) {
            sum += arr[i];
        }

        int left = 0;

        for(int i = M; i < N; i++) {
            sum += arr[i] - arr[i - M];
            System.out.println(sum);
        }

    }
}
