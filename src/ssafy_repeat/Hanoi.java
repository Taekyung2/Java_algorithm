package algorithm_skill;

import java.util.Scanner;

public class Hanoi {
    static StringBuilder ret = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        hanoi(N, 1, 2, 3);
        System.out.println(ret.toString());
    }

    private static void hanoi(int cnt, int from, int temp, int to) {
        if( cnt == 0 ) return;
        hanoi(cnt - 1, from , to, temp);
        ret.append(cnt + " : " + from + " -> " + to + "\n");
        hanoi(cnt - 1, temp, from, to);
    }
}