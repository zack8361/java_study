package programmers.lv1.solved;

public class x만큼간격이있는n개의숫자 {
    public static void main(String[] args) {
        System.out.println(solution(2, 5));
    }

    private static int[] solution(int x, int n) {
        int[] answer = new int[n];

        int addSum = 0;
        for(int i = 0; i< n; i++) {
            addSum += x;
            answer[i] = addSum;
        }
        return answer;
    }
}
