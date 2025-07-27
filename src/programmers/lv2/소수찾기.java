package programmers.lv2;

public class 소수찾기 {
    public static void main(String[] args) {
        String n = "17";
        System.out.println(solution(n));
    }

    private static int solution(String n) {
        int answer = 0;

        permutation(0,n,"");

        return answer;
    }

    private static void permutation(int depth, String n,String str) {


    }
}
