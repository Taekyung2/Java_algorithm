package boj_algorithm._16900;

import java.util.HashMap;
import java.util.Scanner;

public class _16953_atob_dp {
    final static int INF = Integer.MAX_VALUE;
    static long a, b;
    static HashMap<Long, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();
        int ret = dp(a, 1);
        System.out.println(ret == INF ? -1 : ret);
    }

    public static int dp(long cur, int cnt) {
        if(cur > b) return INF;
        if(cur == b) return cnt;
        int ret = cache.getOrDefault(cur, 0);
        if(ret != 0) return ret;
        ret = Math.min(dp(cur * 2, cnt + 1), dp(cur * 10 + 1, cnt + 1));
        cache.put(cur, ret);
        return ret;
    }
}
