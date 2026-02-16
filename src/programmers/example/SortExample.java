package programmers.example;

import  java.util.*;

public class SortExample {
    public static void main(String[] args) {
        HashMap<Integer, Double> map = new HashMap<>();

        for(int i = 1; i<=5; i++) {
            map.put(i, Math.random() * 100);
        }

        System.out.println(map);

        List<Integer> list = new ArrayList<>(map.keySet());
        System.out.println(list);

        list.sort((a,b) -> Double.compare(map.get(b), map.get(a)));

        System.out.println(list);

    }
}
