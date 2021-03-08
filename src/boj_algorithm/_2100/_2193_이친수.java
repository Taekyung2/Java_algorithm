package boj_algorithm._2100;

import java.util.Arrays;
import java.util.Scanner;

public class _2193_이친수 {
    static int N;
    static long[] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cache = new long[N + 1];
        Arrays.fill(cache, -1);
        System.out.println(solve(N));
    }

    public static long solve(int n) {
        if(n == 1 || n == 2) return 1;
        long ret = cache[n];
        if(ret != -1) return ret;
        return cache[n] = solve(n - 1) + solve(n - 2);
    }
}