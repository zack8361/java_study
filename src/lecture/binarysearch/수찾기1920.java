package lecture.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        Arrays.sort(arr1);

        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

//        5
//        1 2 3 4 5
//        5
//        1 3 7 9 5

        for(int i = 0; i < arr2.length; i++){
            int left = 0;
            int right = arr1.length - 1;
            int num = arr2[i];
            int answer = 0;
            while (left <= right){
                int mid = (left + right) / 2;
                if(arr1[mid] >= num){
                    answer = 1;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(answer);
        }
    }
}
