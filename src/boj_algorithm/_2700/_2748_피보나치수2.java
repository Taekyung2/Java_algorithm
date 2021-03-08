package boj_algorithm._2700;

import java.util.Arrays;
import java.util.Scanner;

public class _2748_피보나치수2 {
    static long cache[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cache = new long[N + 1];
        Arrays.fill(cache, -1);
        System.out.println(fibo(N));
    }

    static long fibo(int n) {
        if(n == 1 || n == 2) return 1;
        long ret = cache[n];
        if(ret != -1) return ret;
        return cache[n] = fibo(n - 1) + fibo(n - 2);
    }
}
