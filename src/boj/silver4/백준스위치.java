package boj.silver4;

import java.util.Arrays;
import java.util.Scanner;

public class 백준스위치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];

        for(int i = 0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        for(int i = 0; i<n; i++) {
            int gender = sc.nextInt();
            int index = sc.nextInt();
            int len = 0;
            if(gender == 1) {
                for(int j = index - 1; j < arr.length; j += index) {
                    arr[j] = arr[j] == 0 ? 1 : 0;
                }
            }
            else {
                if(len < arr.length/2) {
                    len = index - 1;
                } else {
                    len = arr.length - index;
                }
                arr[index-1] = arr[index-1] == 0 ? 1 : 0;
                for(int j = 1; j<=len; j++){
                    if(arr[index-1-j] == arr[index-1-+j]) {
                        arr[index-1-j] = arr[index-1-j] == 0 ? 1 : 0;
                        arr[index-1+j] = arr[index-1+j] == 0 ? 1 : 0;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
