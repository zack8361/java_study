package programmers.lv1.solved.low;

public class 삼총사 {

    private static int maxDepth = 3;
    private static int count;
    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        System.out.println(solution(number));

    }

    private static int solution(int[] number) {

        dfs(number,0,0,0);


        return count;
    }

    private static void dfs(int[] number, int depth,int sum, int start) {

        System.out.println("sum = " + sum + " depth = " + depth + " start = " + start);

        if(depth == maxDepth) {
            if(sum ==0) count++;
            return;
        }
        for(int i = start; i<number.length; i++){
            dfs(number, depth+1,sum + number[i],i+1);
        }
    }
}
