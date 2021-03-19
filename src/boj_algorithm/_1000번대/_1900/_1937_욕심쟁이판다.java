package boj_algorithm._1900;

import java.util.*;

public class _1937_욕심쟁이판다 {
    static int N, ret = 0;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int[][] map, cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        cache = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(cache[i], -1);
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();
        }
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++) {
                ret = Math.max(ret, dfs(i, j));
            }
        System.out.println(ret);
    }

    static int dfs(int y, int x) {
        int ret = cache[y][x];
        if(ret != -1) return ret;
        ret = 1;
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d], nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] <= map[y][x]) continue;
            ret = Math.max(ret, dfs(ny, nx) + 1);
        }
        return cache[y][x] = ret;
    }
}
