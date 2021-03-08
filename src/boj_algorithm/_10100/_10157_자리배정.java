package boj_algorithm._10100;

import java.util.Scanner;

public class _10157_자리배정 {
    static int[] dy = {1, 0, -1, 0}, dx = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int R = sc.nextInt();
        int[][] map = new int[R][C];
        int K = sc.nextInt();
        if(K > R * C) {
            System.out.println(0);
            return;
        }
        int cnt = 1, d = 0;
        int y = 0, x = 0;
        while (cnt < K) {
            map[y][x] = cnt;
            int ny = y + dy[d], nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] != 0) {
                d++;
                if(d == 4) d = 0;
                ny = y + dy[d];
                nx = x + dx[d];
            }
            y = ny;
            x = nx;
            cnt++;
        }
        System.out.println((x + 1) + " " + (y + 1));
    }
}
