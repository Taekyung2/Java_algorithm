package boj_algorithm._5500;

import java.util.Scanner;

public class _5585_거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 1000 - sc.nextInt();
        int ret = 0;
        int[] coin = {500, 100, 50, 10, 5, 1};
        for(int c : coin) {
            ret += N / c;
            N %= c;
        }
        System.out.println(ret);
    }
}
