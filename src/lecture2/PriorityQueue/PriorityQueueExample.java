package lecture2.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {


        Queue<Person> queue = new PriorityQueue<>();

        Person person1 = new Person("이찬호", 29);
        Person person2 = new Person("공희진", 27);
        Person person3 = new Person("곽명환", 31);
        Person person4 = new Person("박성재", 31);
        Person person5 = new Person("이자훈", 29);

        queue.add(person1);
        queue.add(person2);
        queue.add(person3);
        queue.add(person4);
        queue.add(person5);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }

    private static class Person implements Comparable<Person>{

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public int compareTo(Person p) {
            if (this.age == p.age) {
                return this.name.compareTo(p.name);
            }
            return this.age - p.age;
        }

        public String toString() {
            return name + " " + age;
        }
    }
}
