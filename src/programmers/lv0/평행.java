package programmers.lv0;

//[[1, 4], [9, 2], [3, 8], [11, 6]]
public class 평행 {
    private static boolean[] visited;
    public static void main(String[] args) {
        int[][] dots = {{1,4}, {9,2}, {3,8}, {11,6}};
        System.out.println(solution(dots));
    }

    private static int solution(int[][] dots) {

        visited = new boolean[dots.length];

        dfs(0,dots, 0, 0.0);

        return 0;
    }

    private static void dfs(int depth, int[][] dots,  int now, double sum) {
        if(depth == 2) {
            return;
        }

        for(int j = now; j< dots.length; j++){
            if(!visited[j]){
                visited[j] = true;
                dfs(depth+1,dots, j+1, sum + (double)(dots[j][1]-dots[now][1])/(dots[j][0]-dots[now][0]));
                visited[j] = false;
            }
        }
    }
}
