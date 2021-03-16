package boj_algorithm._9200;

import java.util.Arrays;
import java.util.Scanner;

public class _9252_LCS2 {
    static String a, b;
    static int alen, blen;
    static int[][] cache;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.next();
        b = sc.next();
        alen = a.length(); blen = b.length();
        cache = new int[alen + 1][blen + 1];
        for(int i = 0; i < alen; i++)
            Arrays.fill(cache[i], -1);
        System.out.println(dp(0, 0));
        make(0, 0);
        System.out.println(sb);
    }

    static int dp(int i, int j) {
        if(i == alen || j == blen) return 0;
        int ret = cache[i][j];
        if(ret != -1) return ret;
        ret = Math.max(dp(i + 1, j), dp(i, j + 1));
        ret = Math.max(ret, dp(i + 1, j + 1) + (a.charAt(i) == b.charAt(j) ? 1 : 0));
        return cache[i][j] = ret;
    }

    static void make(int i, int j) {
        if(i == alen || j == blen) return;;
        if(a.charAt(i) == b.charAt(j)) {
            sb.append(a.charAt(i));
            make(i + 1, j + 1);
        } else if(cache[i + 1][j] >= cache[i][j + 1])
            make(i + 1, j);
        else
            make(i, j + 1);
    }
}
