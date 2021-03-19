package boj_algorithm._2200;

import java.util.Arrays;
import java.util.Scanner;

public class _2225_합분해 {
    final static int MOD = (int)1e9;
    static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        cache = new int[n + 1][k + 1];
        for(int i = 0; i <= n; i++)
            Arrays.fill(cache[i], -1);
        System.out.println(dp(n, k));
    }

    static int dp(int n, int k) {
        if(k == 1) return 1;
        int ret = cache[n][k];
        if(ret != -1) return ret;
        ret = 0;
        for(int i = 0; i <= n; i++)
            ret = (ret + dp(n - i, k - 1)) % MOD;
        return cache[n][k] = ret;
    }
}
