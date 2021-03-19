package boj_algorithm._17100;

import java.util.Scanner;

public class _17144_미세먼지안녕 {
    static int R, C, T, a;
    static int[] dy = {-1, 0, 1, 0}, ry = {1, 0, -1, 0}, dx = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        map = new int[R][C];
        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == -1) a = i;
            }
        while(T-- > 0)
            simulation();
        int ret = 0;
        for(int[] a : map)
            for (int b : a)
                ret += b;
        System.out.println(ret + 2);
    }

    static void simulation() {
        int[][] plus = new int[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                for(int d = 0; d < 4; d++) {
                    int ny = i + dy[d], nx = j + dx[d];
                    if(ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1) continue;
                    plus[ny][nx] += map[i][j] / 5;
                    plus[i][j] -= map[i][j] / 5;
                }
            }
        }
        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++)
                map[i][j] += plus[i][j];

        int x1 = 0, y1 = a - 1, x2 = 0, y2 = a, d = 0;
        while(true) {
            int ny = y1 + dy[d], nx = x1 + dx[d];
            if(ny > a - 1 || ny < 0 || nx < 0 || nx >= C) {
                d++;
                ny = y1 + dy[d]; nx = x1 + dx[d];
            }
            if(map[ny][nx] == -1) {
                map[y1][x1] = 0;
                break;
            }
            if(map[y1][x1] != -1) {
                map[y1][x1] = map[ny][nx];
            }
            y1 = ny; x1 = nx;
        }
        d = 0;
        while(true) {
            int ny = y2 + ry[d], nx = x2 + dx[d];
            if(ny < a || ny >= R || nx < 0 || nx >= C) {
                d++;
                ny = y2 + ry[d]; nx = x2 + dx[d];
            }
            if(map[ny][nx] == -1) {
                map[y2][x2] = 0;
                break;
            }
            if(map[y2][x2] != -1) {
                map[y2][x2] = map[ny][nx];
            }
            y2 = ny; x2 = nx;
        }
    }
}
