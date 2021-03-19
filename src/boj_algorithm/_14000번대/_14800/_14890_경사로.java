package boj_algorithm._14800;

import java.util.Scanner;

public class _14890_경사로 {
    static int N, L, ret = 0;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        map = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        for(int i = 0; i < N; i++) {
            check(i, 0);
            check(i, 1);
        }
        System.out.println(ret);
    }

    private static void check(int c, int type) {
        int cnt = 1;
        for(int i = 0; i < N - 1; i++) {
            int h = (type == 1) ? map[c][i + 1] - map[c][i] : map[i + 1][c] - map[i][c];
            if(h == 0) cnt++;
            else if(h == 1 && cnt >= L) cnt = 1;
            else if(h == -1 && cnt >= 0) cnt = -L + 1;
            else return;
        }
        if(cnt >= 0)
            ret++;
    }
}
