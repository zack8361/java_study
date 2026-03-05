package lecture2.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 간선리스트 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0,1},
                {0,2},
                {2,3},
                {2,4}
        };

        List<List<Integer>> tree = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        System.out.println(tree);
    }
}
