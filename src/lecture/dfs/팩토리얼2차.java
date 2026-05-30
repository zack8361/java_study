package lecture.dfs;

public class 팩토리얼2차 {
    public static void main(String[] args) {
        int n = 5;
        int answer = dfsFactorial(n);

        System.out.println(answer);
    }

    private static int dfsFactorial(int n) {
        if(n == 1) return 1;
        return n * dfsFactorial(n-1);
    }
}
