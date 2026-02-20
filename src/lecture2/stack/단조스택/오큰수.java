package lecture2.stack.단조스택;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
// 4
// 3 5 2 7
public class 오큰수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] answer = new int[N];

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i ++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                Integer i1 = deque.pollLast();
                answer[i1] = arr[i];
            }
            deque.addLast(i);
        }

        for(int i = 0; i < answer.length; i++) {
            if(answer[i] == 0) System.out.print(-1 + "");
            else System.out.print(answer[i] + " ");
        }

    }
}
