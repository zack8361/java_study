package boj.silver2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i< meetings.length; i++){
            if(deque.isEmpty()){
                deque.addLast(meetings[i][1]);
            } else {
                if(deque.peekLast() <= meetings[i][0]){
                    deque.addLast(meetings[i][1]);
                }
            }
        }
        System.out.println(deque.size());
    }
}
