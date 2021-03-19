package boj_algorithm._1700;

import java.util.Scanner;

public class _1712_손익분기점 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int n = 1;
        if(c - b <= 0) {
            System.out.println(-1);
            return;
        }
        while(a >= (c - b) * n) {
            n++;
        }
        System.out.println(n);
    }
}