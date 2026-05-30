package lecture.string;

import java.util.*;

// it is time to study kongs
public class 문장속단어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
        String[] str = st.split(" ");
        PriorityQueue<Node> pq = new PriorityQueue<>();


        int i = 0;
        for(String word : str) {
            pq.add(new Node(word, word.length(),i));
            i++;
        }

        System.out.println(pq.poll().word);

    }

    private static class Node implements Comparable<Node> {
        String word;
        int length;
        int index;

        public Node(String word, int length, int index) {
            this.word = word;
            this.length = length;
            this.index = index;
        }

        public int compareTo(Node otherNode) {
            if(this.length == otherNode.length) {
                return this.index - otherNode.index;
            }
            return otherNode.length - this.length;
        }

        public String toString() {
            return word + " " + length + " " + index;
        }
    }
}
