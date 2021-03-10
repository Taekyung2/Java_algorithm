package boj_algorithm._1200;

import java.util.*;

public class _1261_알고스팟 {
    static class Point {
        int y, x, c;
        Point(int y, int x, int c) {
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }
    static int N, M;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new char[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
            Arrays.fill(visited[i], (int)1e9);
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));
        visited[0][0] = 0;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d], nx = cur.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] <= cur.c) continue;
                if(map[ny][nx] == '1') {
                    if(visited[ny][nx] > cur.c + 1) {
                        visited[ny][nx] = cur.c + 1;
                        q.add(new Point(ny, nx, cur.c + 1));
                    }
                } else {
                    visited[ny][nx] = cur.c;
                    q.add(new Point(ny, nx, cur.c));
                }
            }
        }
        System.out.println(visited[N - 1][M - 1]);
    }
}
