package lecture2.dfs;

public class 잔돈교환 {
    private static int minCount;
    public static void main(String[] args) {
        int[] coins = {10,5,25,1};
        int amount = 30;
        minCount = Integer.MAX_VALUE;
        dfs(coins,amount,0, 0);
        System.out.println(minCount);
    }

    private static void dfs(int[] coins, int amount, int sum, int count) {
        if(sum >= amount) {
            if(sum == amount) {
                minCount = Math.min(minCount, count);
            }
            return;
        }
        for(int i = 0; i < coins.length; i++) {
            dfs(coins, amount, sum + coins[i], count + 1);
        }
    }
}
