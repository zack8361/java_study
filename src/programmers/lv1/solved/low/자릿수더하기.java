package programmers.lv1.solved.low;

public class 자릿수더하기 {
    public static void main(String[] args) {

        System.out.println(solution(987));
    }

    private static int solution(int n) {

        int total = 0;
        String[] strArr = String.valueOf(n).split("");
        for (String s : strArr) {
            total += Integer.parseInt(s);
        }
        return total;
    }
}
