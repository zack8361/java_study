package lecture2.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 네트워크인접리스트V {
    public static void main(String[] args) {

        int n = 3;

        int[][] network = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        List<List<Integer>> tree = new ArrayList<>();

        for(int i= 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < network.length; i++) {
            for(int j = 0; j < network[i].length; j++) {
                if(i != j && network[i][j] == 1) {
                    tree.get(i).add(j);
                }
            }
        }
        for(int i = 0; i < tree.size(); i++) {

        }

    }
}
