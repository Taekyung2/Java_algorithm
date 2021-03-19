package boj_algorithm._2600;

import java.util.Scanner;

public class _2615_오목 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[21][21];
        int[] dy = {-1, 0, 1, 1}, dx = {1, 1, 1, 0};
        for(int i = 1; i <= 19; i++)
            for(int j = 1; j <= 19; j++)
                map[i][j] = sc.nextInt();

        for(int i = 1; i <= 19; i++) {
            for(int j = 1; j <= 19; j++) {
                int cur = map[i][j];
                if(cur == 0) continue;
                for(int d = 0; d < 4; d++) {
                    int cnt = 1, ny = i, nx = j;
                    if(map[ny - dy[d]][nx - dx[d]] == cur) continue;
                    while(true) {
                        ny += dy[d];
                        nx += dx[d];
                        if (ny < 1 || nx < 1 || ny > 19 || nx > 19 || map[ny][nx] != cur) break;
                        cnt++;
                    }
                    if(cnt == 5) {
                        System.out.println(cur);
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}