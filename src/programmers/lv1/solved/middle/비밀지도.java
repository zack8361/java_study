package programmers.lv1.solved.middle;

import java.util.Arrays;

public class 비밀지도 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(solution(n,arr1,arr2));
    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer= new String[n];

        for(int i=0; i<n; i++){
            answer[i] = String.format("%0" + n + "d", Integer.parseInt(Integer.toString(arr1[i] | arr2[i])));
        }

        for(int i = 0; i<n; i++) {
            answer[i] = answer[i].replace("0"," ").replace("1","#");
        }



        return answer;
    }
}
