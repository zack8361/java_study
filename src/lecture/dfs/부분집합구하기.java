package lecture.dfs;

public class 부분집합구하기 {
    private static int n = 3;
    private static int[] arr;
    public static void main(String[] args) {
        arr = new int[n+1];
        dfs(1);
    }

    private static void dfs(int i) {

        if(i == n + 1) {
        } else {
            arr[i] = 1;
            dfs(i+1);

            arr[i] = 0;
            dfs(i+1);

        }
    }
}
