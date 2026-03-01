package lecture2.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class 숨바꼭질 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(N,0));
        HashSet<Integer> visited = new HashSet<>();

        while (!deque.isEmpty()) {
            Node node = deque.pollFirst();

            int currentAmount = node.amount;
            int currentCount = node.count;

            if(currentAmount == M) {
                System.out.println(currentCount);
                break;
            }

            int nextAmount = currentAmount - 1;
            if(!visited.contains(nextAmount)) {
                visited.add(nextAmount);
                deque.addLast(new Node(nextAmount,currentCount + 1));
            }

            nextAmount = currentAmount + 1;
            if(!visited.contains(nextAmount)) {
                visited.add(nextAmount);
                deque.addLast(new Node(nextAmount,currentCount + 1));
            }
            nextAmount = currentAmount * 2;
            if(!visited.contains(nextAmount)) {
                visited.add(nextAmount);
                deque.addLast(new Node(nextAmount,currentCount + 1));
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
