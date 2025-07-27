package programmers.lv1.solved.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(Solution(participant, completion));
    }

    private static String Solution(String[] participant, String[] completion) {

        HashMap<String,Integer> memberMap = new HashMap<>();

        for(String member:participant){
            memberMap.put(member,memberMap.getOrDefault(member,0)+1);
        }

        for(String member: completion) {
            memberMap.put(member, memberMap.getOrDefault(member, 0) - 1);
        }

        for (String member : memberMap.keySet()) {
            if(memberMap.get(member) == 0){
                return member;
            }
        }

        return "0";
    }
}
