package lecture2.stack.단조스택;
import java.util.*;

public class 점진적과부하3 {
    public static void main(String[] args) {
        int[] weights = {25, 23, 31, 28, 25, 25, 27, 29};
        int[] answer = new int[weights.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < weights.length; i++) {
            while(!stack.isEmpty() && weights[stack.peekLast()] < weights[i]) {
                Integer i1 = stack.pollLast();
                answer[i1] = i - i1;
            }
            stack.addLast(i);
        }
        System.out.println(Arrays.toString(answer));
    }
}
