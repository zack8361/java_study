package programmers.lv1.solved.high;

import org.w3c.dom.Node;

import java.util.ArrayDeque;
import java.util.Arrays;

// e = 동쪽
// w = 서쪽
// s = 남쪽
// n = 북쪽
public class 공원산책 {
    private static class Nodes{
        int x = 0;
        int y = 0;
        public Nodes(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        String[] park = {"SOO","OXX","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        System.out.println(solution(park,routes));
    }

    private static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        String[][] map = new String[park.length][park[0].length()];

        for(int i = 0; i< park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = String.valueOf(park[i].charAt(j));
            }
        }

        ArrayDeque<Nodes> queue = new ArrayDeque<>();

        for(int i = 0; i< map.length; i++) {
            for(int j = 0; j<map[i].length; j++) {
                if(map[i][j].equals("S")) {
                    queue.addLast(new Nodes(i,j));
                    for(int k = 0; k<routes.length; k++){
                        String[] route = routes[k].split(" ");

                        String direction = route[0];
                        int distance = Integer.parseInt(route[1]);

                        Nodes nodes = queue.pollFirst();
                        int x = nodes.x;
                        int y = nodes.y;


                        if(direction.equals("W")) {
                            boolean flag = false;
                            if(y-distance>=0){
                                for(int l = 1; l<=distance; l++){
                                    if(map[x][y-l].equals("X")) {
                                        flag = true;
                                        break;
                                    }
                                }
                                if(!flag){
                                    queue.addLast(new Nodes(x,y-distance));
                                }
                            }
                        } else if(direction.equals("E")) {
                            boolean flag = false;
                            if(y+distance<=map.length){
                                for(int l = 1; l<=distance; l++){
                                    if(map[x][y+l].equals("X")) {
                                        flag = true;
                                        break;
                                    }
                                }
                                if(!flag){
                                    queue.addLast(new Nodes(x,x+distance));
                                }
                            }
                        } else if(direction.equals("S")) {
                            boolean flag = false;
                            if (x + distance <= map.length) {
                                for (int l = 1; l <= distance; l++) {
                                    if (map[x + l][y].equals("X")) {
                                        flag = true;
                                        break;
                                    }
                                }
                                if (!flag) {
                                    queue.addLast(new Nodes(x + distance, y));
                                }
                            }
                        } else if(direction.equals("N")) {
                            boolean flag = false;
                            if(x-distance>=0){
                                for(int l = 1; l<=distance; l++){
                                    if(map[x-l][y].equals("X")) {
                                        flag = true;
                                        break;
                                    }
                                }
                                if(!flag){
                                    queue.addLast(new Nodes(x-distance,y));
                                }
                            }
                        }

                        if(queue.isEmpty()){
                            queue.addLast(new Nodes(x,y));
                        }
                    }
                    Nodes nodes = queue.pollFirst();
                    answer[0] = nodes.x;
                    answer[1] = nodes.y;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
