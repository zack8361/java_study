package programmers.example;

import java.util.*;

public class SortExample2 {
    public static void main(String[] args) {
        String[] arr = {"abce", "abcd", "cdx"};
        int N = 1;

        Map<Integer,String> map = new HashMap<>();
        for(int i = 1; i <= arr.length; i++) {
            map.put(i, arr[i-1]);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((a,b) -> {
            char c = map.get(a).charAt(N);
            char d = map.get(b).charAt(N);

            if(c == d) {
                return map.get(a).compareTo(map.get(b));
            }

            return Character.compare(c, d);
        });

        System.out.println(list);


    }
}
