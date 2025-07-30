package programmers.lv1.solved.middle;

import java.util.Arrays;

public class 비밀지도 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9,20,28,18,11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(solution(n,arr1,arr2));
    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {

        int[] status = new int[n];

        for(int i=0; i<status.length; i++) {

            status[i] += Integer.parseInt(Integer.toString(arr1[i]),2) + Integer.parseInt(Integer.toString(arr2[i]),2);
        }

//        String[][] map = new String[n][n];
//
//        for(int i=0; i<status.length; i++) {
//            for(int j=0; j<status.length; j++) {
//                char part = String.valueOf(status[i]).charAt(j);
//                if(part != '0') map[i][j] = "#";
//                else map[i][j] = " ";
//            }
//        }

        String[] answer = new String[n];
//
//        for(int i=0; i<map.length; i++) {
//            String value = "";
//            for (int j = 0; j < map.length; j++) {
//                value += map[i][j];
//            }
//            answer[i] = value;
//        }

        return answer;
    }
}
