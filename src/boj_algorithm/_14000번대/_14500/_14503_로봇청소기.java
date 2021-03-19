package boj_algorithm._14500;

import java.util.Scanner;

public class _14503_로봇청소기 {

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M, d, ret = 0;
    static int[][] map;
    static Point cleaner;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        int r = sc.nextInt();
        int c = sc.nextInt();
        d = sc.nextInt();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j]= sc.nextInt();
            }
        }
        cleaner = new Point(r, c);
        clean();
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2)
                    ret++;
            }
        }
        System.out.println(ret);
    }

    private static void clean() {
        loop:
        while(true) {
            map[cleaner.y][cleaner.x] = 2;
            int c = 0;
            while(true) {
                if(c == 4) break;
                if (d == 0) d = 3;
                else d--;
                int ny = cleaner.y + dy[d];
                int nx = cleaner.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    c++;
                    continue;
                }
                if(map[ny][nx] == 0) {
                    cleaner.y = ny;
                    cleaner.x = nx;
                    continue loop;
                }
                c++;
            }
            int by = cleaner.y - dy[d];
            int bx = cleaner.x - dx[d];
            if(by < 0 || bx < 0 || by >= N || bx >= M || map[by][bx] == 1) break;
            cleaner.y = by;
            cleaner.x = bx;
        }
    }
}
