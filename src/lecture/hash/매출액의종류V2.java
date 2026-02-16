package lecture.hash;

import java.util.*;

public class 매출액의종류V2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        list.add(map.size());
        int lt = 0;
        int rt = M;

        while (rt < N) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            map.put(arr[lt],  map.get(arr[lt])-1);
            if(map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            list.add(map.size());

            lt ++;
            rt ++;
        }
        System.out.println(list);


    }
}
