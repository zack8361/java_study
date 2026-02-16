package lecture.hash;

import java.util.HashMap;
import java.util.Map;

public class 모든아나그램찾기 {
    public static void main(String[] args) {
        String S = "bacaAacba";
        String T = "abc";

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0) + 1);
        }

        Map<Character, Integer> compareMap = new HashMap<>();

        int lt = 0;
        int rt = T.length() - 1;
        for(int i =0; i < rt; i++){
            compareMap.put(S.charAt(i), compareMap.getOrDefault(S.charAt(i), 0) + 1);
        }

        int cnt = 0;
        while (rt < S.length()) {
            compareMap.put(S.charAt(rt), compareMap.getOrDefault(S.charAt(rt), 0) + 1);
            System.out.println(compareMap);
            if(compareMap.equals(map)) cnt ++;
            compareMap.put(S.charAt(lt), compareMap.get(S.charAt(lt)) - 1);
            if(compareMap.get(S.charAt(lt)) == 0){
                compareMap.remove(S.charAt(lt));
            }
            lt ++;
            rt ++;
        }
        System.out.println(cnt);

    }
}
