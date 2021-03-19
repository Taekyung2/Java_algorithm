package boj_algorithm._1700;

import java.util.Scanner;

public class _1789_수들의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong(), n = 1;
        while(n * (n + 1) / 2 <= s) n++;
        System.out.println(n - 1);
    }
}
