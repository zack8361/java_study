package programmers.lv1.solved.low;

public class 자연수뒤집어배열만들기 {
    public static void main(String[] args) {
        System.out.println(solution(12345));
    }

    private static int[] solution(int n) {

        String[] arr = String.valueOf(n).split("");
        int[] answer = new int[arr.length];

        for(int i = arr.length-1; i >= 0; i--) {
            answer[answer.length-1-i] = Integer.parseInt(arr[i]);
        }

        return answer;
    }
}
