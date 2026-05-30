package boj.gold4;

import java.util.*;

public class 가장가까운공통조상 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int n = 0; n < testCase; n++) {
            int N = sc.nextInt();

            Map<String,String> map = new HashMap<>();

            for(int i = 0; i < N-1; i++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();
                map.put(String.valueOf(child), String.valueOf(parent));
            }
            String p = sc.next();
            String q = sc.next();

            Set<String> parentSet = new HashSet<>();

            while (p!= null) {
                parentSet.add(p);
                p = map.get(p);
            }

            while (q!= null){
                if(parentSet.contains(q)) {
                    System.out.println(q);
                    break;
                }
                q = map.get(q);
            }
        }

    }
}
