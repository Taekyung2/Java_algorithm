package boj_algorithm._2100;

import java.util.Arrays;
import java.util.Scanner;

public class _2163_초콜릿자르기 {
    static int N, M;
    static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        cache = new int[N + 1][M + 1];
        for(int i = 0; i <= N; i++)
            Arrays.fill(cache[i], -1);
        System.out.println(dp(N, M));
    }

    static int dp(int n, int m) {
        int ret = cache[n][m];
        if(ret != -1) return ret;
        if(n == 1) return cache[n][m] = m - 1;
        if(m == 1) return cache[n][m] = n - 1;
        return cache[n][m] = Math.min(n * dp(1, m) + n - 1, m * dp(n, 1) + m - 1);
    }
}
