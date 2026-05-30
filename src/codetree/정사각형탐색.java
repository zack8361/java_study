package codetree;

import java.util.Arrays;

public class 정사각형탐색 {
    public static void main(String[] args) {
        int N = 4;
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("원본 배열");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        for(int size = 2; size <=N; size ++) {
            for (int i = 0; i <= N -size; i++) {
                for (int j = 0; j <= N-size; j++) {
                    for (int x = i; x < i + size; x++) {
                        for (int y = j; y < j + size; y++) {
                            System.out.print(arr[x][y] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("-------------------");
                }
            }
        }
    }
}
