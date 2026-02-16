package programmers.dfs;

public class 멀리뛰기 {

    private static long count;
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    private static long solution(int n) {
        dfs(n, 0);

        return count % 1234567;
    }

    private static void dfs(int n, int i) {
        if(i == n) {
            count++;
            return;
        }
        dfs(n, i+1);
        dfs(n, i+2);
    }
}
