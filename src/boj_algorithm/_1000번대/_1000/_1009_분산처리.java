package boj_algorithm._1000;

import java.util.Scanner;

public class _1009_분산처리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int a = sc.nextInt();
            int b = (sc.nextInt() - 1) % 4 + 1;
            System.out.println((int)(Math.pow(a, b) - 1) % 10 + 1);
        }
    }
}