package boj_algorithm._4700;

import java.util.Scanner;

public class _4796_캠핑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while(true) {
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();
            if(L + P + V == 0) break;
            int ret = V / P * L;
            ret += Math.min(V % P, L);
            System.out.println("Case " + t++ + ": " + ret);
        }
    }
}
