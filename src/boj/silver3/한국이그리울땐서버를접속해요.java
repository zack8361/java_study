package boj.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class 한국이그리울땐서버를접속해요 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] arr = new String[N];

        String patten = sc.next();
        String[] pattenArr = patten.split("\\*",2);

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < N; i++) {
            if(arr[i].length() < patten.length()-1) {
                System.out.println("NE");
                continue;
            }
            if(arr[i].startsWith(pattenArr[0]) && arr[i].endsWith(pattenArr[1])) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
