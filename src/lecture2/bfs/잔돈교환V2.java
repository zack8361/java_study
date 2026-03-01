package lecture2.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;

public class 잔돈교환V2 {
    public static void main(String[] args) {
        int[] coins = {10,5,25,1};
        int amount = 30;

        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(amount,0));
        HashSet<Integer> set = new HashSet<>();

        while (!deque.isEmpty()) {
            Node node = deque.pollFirst();
            int currentAmount = node.amount;
            int currentCount = node.count;

            System.out.println("currentCount = " + currentCount + ", currentAmount = " + currentAmount);

            if(currentAmount == 0) {
                System.out.println(currentCount);
                break;
            }

            for(int i = 0; i < coins.length; i++) {
                int nextAmount = currentAmount - coins[i];
                if(nextAmount < 0) continue;
                if(!set.contains(nextAmount)) {
                    set.add(nextAmount);
                    deque.addLast(new Node(nextAmount,currentCount+1));
                }
            }
        }
    }
    private static class Node {
        int amount;
        int count;
        public Node(int amount, int count) {
            this.amount = amount;
            this.count = count;
        }
    }
}
