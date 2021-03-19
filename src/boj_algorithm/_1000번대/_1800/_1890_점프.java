package boj_algorithm._1800;

import java.util.*;

public class _1890_점프 {
    static int N;
    static int[][] map;
    static long[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        cache = new long[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(cache[i], -1);
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();
        }
        System.out.println(dp(0, 0));
    }

    static long dp(int y, int x) {
        if(y == N - 1 && x == N - 1) return 1;
        if(y < 0 || x < 0 || y >= N || x >= N || map[y][x] == 0) return 0;
        long ret = cache[y][x];
        if(ret != -1) return ret;
        ret = 0;
        ret += dp(y + map[y][x], x) + dp(y, x + map[y][x]);
        return cache[y][x] = ret;
    }
}
