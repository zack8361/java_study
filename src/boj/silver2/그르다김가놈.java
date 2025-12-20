package boj.silver2;

import java.util.*;

public class 그르다김가놈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }


        List<Integer> list = new ArrayList<>();

        for(int i: arr) {
            if (i <= K) continue;
            if (i <= (2 * K)) {
                i = i - K;
            } else {
                i = i - (2 * K);
            }
            list.add(i);
        }

        if(list.isEmpty()){
            System.out.println(-1);
        }

        Collections.sort(list);

        int left = 1;
        int right = list.get(list.size() - 1);
        int ans = -1;


        while (left <= right) {
            int mid = (left + right) / 2;
            if(isCondition(mid,list,M)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean isCondition(int mid, List<Integer> list, int m) {
        int sum = 0;
        for (Integer i : list) {
            sum += (i /mid);
        }
        if(sum<=m){
            return true;
        }
        return false;
    }
}
