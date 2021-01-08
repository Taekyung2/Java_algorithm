package ssafy_repeat;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityTest {
    static class Student implements Comparable<Student> {
        int no, score;

        public Student(int no, int score) {
            super();
            this.no = no;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return this.no - o.no;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String[] args) {
//        PriorityQueue<Student> queue = new PriorityQueue<>();
        PriorityQueue<Student> queue = new PriorityQueue<>((o1, o2) -> o2.score - o1.score);
        queue.offer(new Student(10, 100));
        queue.offer(new Student(1, 50));
        queue.offer(new Student(5, 80));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}