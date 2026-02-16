package programmers.lv1.solved.high;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 실패율 {
    public static void main(String[] args) {

        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};

        int[] answer = new int[N];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =1; i<=N; i++) {
            map.put(i,0);
        }

        for(int i =0; i<stages.length; i++) {
            if(stages[i] <= N) {
                if (map.get(stages[i]) == null) {
                    map.put(stages[i], 0);
                } else {
                    map.put(stages[i], map.get(stages[i]) + 1);
                }
            }
        }
        double num = stages.length;

        Map<Integer,Double> failMap = new HashMap<>();
        for(int i: map.keySet()) {
            double ans = (double) (map.get(i) / num);
            int stageFailNum = map.get(i);
            num -= stageFailNum;
            failMap.put(i, ans);
        }
        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        System.out.println(list);
    }
}
