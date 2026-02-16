package lecture.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 두배열합치기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 =new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] arr2 =new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        int p1 = 0, p2 = 0;

        List<Integer> list = new ArrayList<>();
        while (p1 < N && p2 < M) {
            if(arr1[p1] < arr2[p2]) {
                list.add(arr1[p1++]);
            } else {
                list.add(arr2[p2++]);
            }
        }

        System.out.println(list);

    }
}
