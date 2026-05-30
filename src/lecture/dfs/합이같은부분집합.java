package lecture.dfs;

import java.util.Scanner;

public class 합이같은부분집합 {
    private static int total = 0;
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        if(dfs(0,0,arr,"")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    private static boolean dfs(int now, int sum, int[] arr,String str) {

        if(total - sum == sum) {
            return true;
        }
        for(int i = now; i < arr.length; i++) {
            if(dfs(i+1,sum+arr[i],arr,str+arr[i] + " ")){
                return true;
            };
        }

        return false;
    }
}
