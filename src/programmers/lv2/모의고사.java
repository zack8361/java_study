package programmers.lv2;

import java.util.*;

public class 모의고사 {
    private static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        System.out.println(solution(answers));
    }

    private static int[] solution(int[] answers) {

        Map<Integer, Integer> answerMap = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        map.put(1, Arrays.asList(1, 2, 3, 4, 5));
        map.put(2, Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        map.put(3, Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        int max = Integer.MIN_VALUE;

        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);

            int count = 0;
            int iter = 0;

            for (int i = 0; i < list.size(); i++) {
                if (iter == answers.length) {
                    iter = 0;
                } else if (list.get(i) == answers[iter]) {
                    count++;
                }
                iter++;
            }
            max = Math.max(max, count);
            answerMap.put(key,count);
        }

        for (Integer i : answerMap.keySet()) {
            if(answerMap.get(i) == max) {
                answerList.add(i);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
