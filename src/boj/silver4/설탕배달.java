package boj.silver4;

import java.util.Scanner;

public class 설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;

        int N = sc.nextInt();
        while (N >= 0) {
            if(N % 5 == 0) {
                count += N/5;
                System.out.println(count);
                return;
            }
            N -= 3;
            count++;
        }
        System.out.println(-1);
    }
}
