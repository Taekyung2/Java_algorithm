package ssafy_repeat;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Object[] nodes;
    private int lastIndex;
    private final int SIZE;

    public BinaryTree(int size) {
        nodes = new Object[size + 1];
        this.SIZE = size;
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean isFull() {
        return lastIndex == SIZE;
    }

    public void add(Object e) {
        if(isFull()) {
            System.out.println("포화");
            return;
        }
        nodes[++lastIndex] = e;
    }

    public void searchPreOrder(int index) {
        if(index <= lastIndex) {
            System.out.print(nodes[index] + " ");
            searchPreOrder(index * 2);
            searchPreOrder(index * 2 + 1);
        }
    }

    public void searchInOrder(int index) {
        if(index <= lastIndex) {
            searchInOrder(index * 2);
            System.out.print(nodes[index] + " ");
            searchInOrder(index * 2 + 1);
        }
    }

    public void searchPostOrder(int index) {
        if(index <= lastIndex) {
            searchPostOrder(index * 2);
            searchPostOrder(index * 2 + 1);
            System.out.print(nodes[index] + " ");
        }
    }

    public void searchBFS() {
        if(isEmpty()) return;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while(!queue.isEmpty()) {
           int cur = queue.poll();
            System.out.print(nodes[cur] + " ");
           if(cur * 2 <= lastIndex) queue.offer(cur * 2);
           if(cur * 2 + 1 <= lastIndex) queue.offer(cur * 2 + 1);
        }
        System.out.println();
    }

    public void searchBFS2() {
        if(isEmpty()) return;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s = 0; s < size; s++) {
                int cur = queue.poll();
                System.out.print(nodes[cur] + " ");
                if (cur * 2 <= lastIndex) queue.offer(cur * 2);
                if (cur * 2 + 1 <= lastIndex) queue.offer(cur * 2 + 1);
            }
            System.out.println();
        }
    }
}