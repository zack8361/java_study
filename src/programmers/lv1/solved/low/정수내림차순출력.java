package programmers.lv1.solved.low;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 정수내림차순출력 {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    private static long solution(long n) {

        StringBuilder sb = new StringBuilder();

        String[] strArr = String.valueOf(n).split("");
        long[] answerArr = new long[strArr.length];

        for(int i=0; i<strArr.length; i++){
            answerArr[i] = Long.parseLong(strArr[i]);
        }

        Arrays.sort(answerArr);


        return Long.parseLong(sb.toString());

    }
}
