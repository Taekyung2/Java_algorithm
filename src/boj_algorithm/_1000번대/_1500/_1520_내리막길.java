package boj_algorithm._1500;

import java.util.Scanner;

public class _1520_내리막길 {
    static int N, M;
    static int[][] map;
    static int[][] cache;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        cache = new int[N][M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                cache[i][j] = -1;
            }
        System.out.println(dfs(0, 0));
    }

    static int dfs(int y, int x) {
        if(y == N - 1 && x == M - 1) return 1;
        if(cache[y][x] != -1) return cache[y][x];
        cache[y][x] = 0;
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d], nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[y][x] <= map[ny][nx]) continue;
            cache[y][x] += dfs(ny, nx);
        }
        return cache[y][x];
    }
}
