package lecture.string;

import java.util.*;

public class 가장짧은문자거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        Map<String, List<Integer>> map = new HashMap<>();
        map.put(t, new ArrayList<>());


        for(int i = 0; i< s.length(); i++) {
            if(String.valueOf(s.charAt(i)).equals(t)) {
                map.get(t).add(i);
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if(String.valueOf(s.charAt(i)).equals(t)) {
                System.out.println(0);
                continue;
            }

            int min = Integer.MAX_VALUE;
            for(int j : map.get(t)) {
                min = Math.min(min, Math.abs(j-i));
            }
            System.out.println(min);
        }

    }
}
