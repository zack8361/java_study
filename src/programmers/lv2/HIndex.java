package programmers.lv2;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = 0;

        Arrays.sort(citations);

        for(int i : citations) {
            System.out.println(i);
        }


        while (true) {
            int leftCnt = 0;
            int rightCnt = 0;

            for (int i : citations) {
                if (i <= answer) {
                    leftCnt++;
                    System.out.println("hi");
                }

                if( i>= answer) {
                    rightCnt++;
                }
            }
            if (leftCnt == rightCnt) break;
            answer++;
        }
    }
}
