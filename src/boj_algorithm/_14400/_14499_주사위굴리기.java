package boj_algorithm._14400;

import java.util.Scanner;

public class _14499_주사위굴리기 {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = new int[6];
    static int[] dy = {0, 0, 0, -1, 1}, dx = {0, 1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        y = sc.nextInt();
        x = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        for(int i = 0; i < K; i++) {
            int d = sc.nextInt();
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            move(d);
            System.out.println(dice[0]);
            if(map[ny][nx] != 0) {
                dice[5] = map[ny][nx];
                map[ny][nx] = 0;
            }
            else {
                map[ny][nx] = dice[5];
            }
            y = ny;
            x = nx;
        }
    }

    private static void move(int d) {
        int[] tmp = dice.clone();
        switch (d) {
            case 1 -> {
                dice[0] = tmp[3];
                dice[2] = tmp[0];
                dice[3] = tmp[5];
                dice[5] = tmp[2];
            }
            case 2 -> {
                dice[0] = tmp[2];
                dice[2] = tmp[5];
                dice[3] = tmp[0];
                dice[5] = tmp[3];
            }
            case 3 -> {
                dice[0] = tmp[1];
                dice[1] = tmp[5];
                dice[4] = tmp[0];
                dice[5] = tmp[4];
            }
            case 4 -> {
                dice[0] = tmp[4];
                dice[1] = tmp[0];
                dice[4] = tmp[5];
                dice[5] = tmp[1];
            }
        }
    }
}