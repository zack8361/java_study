package programmers.lv1.solved.high;

import java.util.HashMap;
import java.util.Map;

public class 붕대감기PCCP {
    public static void main(String[] args) {
        int[] bandages = {5,1,5};
        int health = 30;
        int[][] attacks = {{2,10},{9,15},{10,5},{11,5}};
        System.out.println(solution(bandages, health, attacks));
    }

    private static int solution(int[] bandages, int health, int[][] attacks) {

        int continuousTime = bandages[0];
        int healAmount = bandages[1];
        int plusHealth = bandages[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] attack : attacks) {
            map.put(attack[0],attack[1]);
        }

        int totalCount = attacks[attacks.length-1][0];


        int count = 0;
        int amount = 0;

        for(int i = 1; i<=totalCount; i++){
            if(map.containsKey(i)){
                health -= map.get(i);
                if(health <= 0) return -1;
                else {
                    count = 0;
                    amount = healAmount;
                }
            }
            count++;
            if(count == continuousTime) {
                health += plusHealth += healAmount;
                count = 0;
                amount = 0;
            } else {
                health += amount;
            }
        }




        return 0;
    }
}
