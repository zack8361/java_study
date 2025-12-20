package boj.silver3;
// 7
//3 10
//5 20
//1 10
//1 20
//2 15
//4 40
//2 200

import java.util.Arrays;
import java.util.Scanner;

public class 퇴사 {
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N];
        int[] P = new int[N];

        for(int i=0; i<N; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        dfs(0,0,T,P,0);
        System.out.println(max);
    }

    private static void dfs(int now, int sum, int[] T, int[] P,int idx) {

        max = Math.max(max,sum);

        for (int i = now; i < T.length; i++) {
            if(i + T[i] <= T.length){
                dfs(i + T[i], sum + P[i], T, P,now + T[i]);
            }
        }
    }
}
