package programmers.lv2;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class 프로세스 {
    public static void main(String[] args) {
        int[] priorities= {2,1,3,2};
        int location = 2;
        System.out.println(Solution(priorities,location));
    }

    private static int Solution(int[] priorities, int location) {
        ArrayDeque<Data> deque = new ArrayDeque<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<priorities.length; i++) {
            deque.add(new Data(i,priorities[i]));
            priorityQueue.add(priorities[i]);
        }

        int count = 0;

        while (!deque.isEmpty()) {
            Data data = deque.pollFirst();
            if(data.getValue() == priorityQueue.peek()){
                priorityQueue.poll();
                count++;
                if(data.getIndex() == location) return count;

            }
            else {
                deque.addLast(data);
            }
        }
        return 0;
    }

    private static class Data {
        private int index;
        private int value;

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }

        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
