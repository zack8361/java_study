package boj.silver3;

import java.util.Scanner;

//4
//2 3 1
//5 2 4 1

public class 주유소{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dist = new long[N-1];
        long[] price = new long[N];

        for(int i = 0; i < N-1; i++){
            dist[i] = sc.nextLong();
        }
        for(int i = 0; i < N; i++){
            price[i] = sc.nextLong();
        }
        long min = Long.MAX_VALUE;

        long ans = 0;

        for(int i=0; i<dist.length; i++){
            min = Math.min(min, price[i]);

            ans += min * dist[i];

        }

        System.out.println(ans);

    }
}
