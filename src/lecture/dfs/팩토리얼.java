package lecture.dfs;

public class 팩토리얼 {
    public static void main(String[] args) {
        int n = 5;

        dfsFactorial(n,1);
    }

    private static void dfsFactorial(int n, int sum) {
        if(n == 0) return;
        System.out.println(sum);
        dfsFactorial(n-1, sum *n);
    }
}
