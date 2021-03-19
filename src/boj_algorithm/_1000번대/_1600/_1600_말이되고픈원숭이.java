package boj_algorithm._1600;

import java.util.*;

public class _1600_말이되고픈원숭이 {
    static class Point {
        int y, x, cnt;
        Point(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    static int K, M, N, ret = -1;
    static int[][] map;
    static int[][][] visited;
    static int[] dy = {-1, 0, 1, 0, -2, -2, -1, 1, 2, 2, 1, -1}, dx = {0, 1, 0, -1, -1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N][M];
        visited = new int[N][M][K + 1];
        for(int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));
        while(!q.isEmpty()) {
            Point p = q.poll();
            if(p.y == N - 1 && p.x == M - 1) {
                ret = visited[p.y][p.x][p.cnt];
                break;
            }
            int u = (p.cnt == K) ? 4 : 12;
            for(int d = 0; d < u; d++) {
                int ny = p.y + dy[d], nx = p.x + dx[d];
                int nz = d < 4 ? p.cnt : p.cnt + 1;
                if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 1 || visited[ny][nx][nz] > 0) continue;
                visited[ny][nx][nz] = visited[p.y][p.x][p.cnt] + 1;
                q.add(new Point(ny, nx, nz));
            }
        }
        System.out.println(ret);
    }
}
