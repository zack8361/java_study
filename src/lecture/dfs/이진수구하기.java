package lecture.dfs;

public class 이진수구하기 {
    public static void main(String[] args) {
        int n = 11;
        dfs(n);
    }

    private static void dfs(int n) {
        if(n == 0) return;

        dfs(n/2);
        System.out.print(n%2 +" ");
    }
}
