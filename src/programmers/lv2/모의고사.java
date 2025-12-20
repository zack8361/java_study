package programmers.lv2;

import java.util.*;

public class 모의고사 {

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        System.out.println(solution(answers));
    }

    private static int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] score = new int[3];

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == patterns[0][i%patterns[0].length]) score[0]++;
            if(answers[i] == patterns[1][i%patterns[1].length]) score[1]++;
            if(answers[i] == patterns[2][i%patterns[2].length]) score[2]++;
        }

        int max = Integer.MIN_VALUE;

        for (int i : score) {
            max = Math.max(max, i);
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < score.length; i++) {
            if(score[i] == max) {
                result.add(i+1);
            }
        }
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();

    }
}
