package lecture2.dfs;

public class 타겟넘버 {
    private static int count = 0;
    private static boolean[] visited;
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        int target = 3;
        visited = new boolean[numbers.length];

        dfs(numbers,0,target,0);

        System.out.println(count);
    }

    private static void dfs(int[] numbers, int depth,int target, int sum) {
        if (depth == numbers.length) {
            if(sum == target) {
                count ++;
            }
            return;
        }

        dfs(numbers, depth + 1, target,sum + numbers[depth]);
        dfs(numbers, depth + 1, target,sum - numbers[depth]);

    }
}
