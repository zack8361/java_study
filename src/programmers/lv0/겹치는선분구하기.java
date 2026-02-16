package programmers.lv0;

public class 겹치는선분구하기 {
    public static void main(String[] args) {
        int[][] lines = {{0, 1}, {2, 5}, {3, 9}};
        System.out.println(solution(lines));
    }

    private static int solution(int[][] lines) {
        int answer = 0;
        int answerArray[] = new int[201];

        for(int i = 0; i< lines.length; i++){
            for(int j = lines[i][0]+100; j< lines[i][1]+100; j++){
                answerArray[j]++;
            }
        }



        return answer;
    }
}
