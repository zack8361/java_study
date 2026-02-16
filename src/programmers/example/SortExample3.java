package programmers.example;
import java.util.Scanner;

public class SortExample3 {

    private static boolean[] visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[M][3];

        for(int i = 0; i < M; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        visited = new boolean[N];

        dfs(arr, 0, 0, 1);

    }

    private static void dfs(int[][] arr, int sum, int depth, int now) {
        
        if(depth == 4) {
            System.out.println(sum);
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i][0] == now && !visited[i]) {
                visited[now-1] = true;
                dfs(arr, sum + arr[i][2], depth + 1, arr[i][0]);
                visited[now-1] = false;
            }
        }
    }
}
