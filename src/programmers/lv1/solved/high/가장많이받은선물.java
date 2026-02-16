package programmers.lv1.solved.high;

import java.util.Arrays;
import java.util.HashMap;

public class 가장많이받은선물 {
    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {
                "muzi frodo",
                "muzi frodo",
                "ryan muzi",
                "ryan muzi",
                "ryan muzi",
                "frodo muzi",
                "frodo ryan",
                "neo muzi"
        };
        System.out.println(solution(friends,gifts));
    }

    private static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        HashMap<String,Integer> friendsMap = new HashMap<>();

        for(int i = 0; i < friends.length; i++){
            friendsMap.put(friends[i],i);
        }

        int[] giftScore = new int[friends.length];
        int[][] eachOtherGiftScore = new int[friends.length][friends.length];

        for(int i=0; i<gifts.length; i++){
            String[] str = gifts[i].split(" ");
            giftScore[friendsMap.get(str[0])]++;
            giftScore[friendsMap.get(str[1])]--;
            eachOtherGiftScore[friendsMap.get(str[0])][friendsMap.get(str[1])]++;
        }
        for(int i =0; i < friends.length; i++) {

            for (int j = 0; j < friends.length; j++) {
                if( i == j) continue;
            }
        }



        System.out.println(Arrays.toString(giftScore));

        return answer;
    }
}
