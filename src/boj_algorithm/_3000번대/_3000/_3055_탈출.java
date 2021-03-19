package boj_algorithm._3000;

import java.util.*;

public class _3055_탈출 {
    static class Point {
        int y, x, k;
        Point(int y, int x, int k) {
            this.y = y;
            this.x = x;
            this.k = k;
        }
    }
    static int R, C;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static char[][] map;
    static Point S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt(); C = sc.nextInt();
        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            String s = sc.next();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S') S = new Point(i, j, 0);
            }
        }
        bfs();
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        int[][] dist = new int[R][C];
        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    q.add(new Point(i, j, 1));
                    dist[i][j] = 1;
                }
            }
        q.add(S);
        dist[S.y][S.x] = 1;
        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int d = 0; d < 4; d++) {
                int ny = p.y + dy[d], nx = p.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == 'X' || dist[ny][nx] > 0) continue;
                if(map[ny][nx] == 'D') {
                    if(p.k == 1) continue;
                    System.out.println(dist[p.y][p.x]);
                    return;
                }
                dist[ny][nx] = dist[p.y][p.x] + 1;
                q.add(new Point(ny, nx, p.k));
            }
        }
        System.out.println("KAKTUS");
    }
}
