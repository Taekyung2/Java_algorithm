package boj_algorithm._14800;

import java.util.LinkedList;
import java.util.Scanner;

public class _14891_톱니바퀴 {
    static int K;
    static LinkedList<Character>[] wheel = new LinkedList[4];
    static boolean[] chk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 4; i++) {
            wheel[i] = new LinkedList<>();
        }
        for(int i = 0; i < 4; i++) {
            String tmp = sc.next();
            for(int j = 0; j < 8; j++) {
                wheel[i].add(tmp.charAt(j));
            }
        }
        K = sc.nextInt();
        for(int i = 0; i < K; i++) {
            chk = new boolean[4];
            rotate(sc.nextInt() - 1, sc.nextInt());
        }
        int ret = 0;
        for(int i = 0; i < 4; i++) {
            if(wheel[i].get(0) == '1') {
                ret += Math.pow(2, i);
            }
        }
        System.out.println(ret);
    }

    private static void rotate(int n, int d) {
        if(chk[n]) return;
        chk[n] = true;
        int left = 6, right = 2;
        if(d == 1)  {
            wheel[n].addFirst(wheel[n].pollLast());
            left = 7; right = 3;
        }
        else {
            wheel[n].addLast(wheel[n].pollFirst());
            left = 5; right = 1;
        }
        if(n < 3 && wheel[n].get(right) != wheel[n + 1].get(6)) rotate(n + 1, -d);
        if(n > 0 && wheel[n].get(left) != wheel[n - 1].get(2)) rotate(n - 1, -d);
    }
}