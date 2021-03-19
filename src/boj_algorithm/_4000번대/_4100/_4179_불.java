package boj_algorithm._4100;

import java.util.*;

public class _4179_불 {
    static class Point {
        int y, x, c;
        Point(int y, int x, int c) {
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }
    static int R, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        char[][] map = new char[R][C];
        int[][] dist = new int[R][C];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        Point S = null;
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            String s = sc.next();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'J') {
                    S = new Point(i, j, 0);
                    map[i][j] = '.';
                } else if(map[i][j] == 'F')
                    q.add(new Point(i, j, 1));
            }
        }
        q.add(S);
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d], nx = cur.x + dx[d];
                if(cur.c == 0 && chk(ny, nx)) {
                    System.out.println(dist[cur.y][cur.x] + 1);
                    return;
                }
                if(chk(ny, nx) || map[ny][nx] != '.') continue;
                if(cur.c == 0 && dist[ny][nx] == 0) {
                    dist[ny][nx] = dist[cur.y][cur.x] + 1;
                    q.add(new Point(ny, nx, cur.c));
                }
                else if(cur.c == 1) {
                    map[ny][nx] = 'F';
                    q.add(new Point(ny, nx, cur.c));
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static boolean chk(int y, int x) {
        return y < 0 || x < 0 || y >= R || x >= C;
    }
}