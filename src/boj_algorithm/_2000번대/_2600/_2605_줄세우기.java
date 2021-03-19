package boj_algorithm._2600;

import java.util.LinkedList;
import java.util.Scanner;

public class _2605_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            int n = sc.nextInt();
            int idx = i - n - 1;
            list.add(idx, i);
        }
        for(int n : list)
            System.out.print(n + " ");
    }
}
