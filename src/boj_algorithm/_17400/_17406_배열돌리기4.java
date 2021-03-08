package boj_algorithm._17400;

import java.util.Scanner;

public class _17406_배열돌리기4 {

    static class Tuple {
        int r, c, s;
        Tuple(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    static boolean[] chk;
    static int N, M, K, ret = Integer.MAX_VALUE;
    static int[] picked;
    static int[][] arr, tmp;
    static Tuple[] order;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        tmp = new int[N + 1][M + 1];
        arr = new int[N + 1][M + 1];
        picked = new int[K];
        chk = new boolean[K];
        order = new Tuple[K];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
                tmp[i][j] = arr[i][j];
            }

        for(int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            order[i] = new Tuple(r, c, s);
        }
        perm(0);

        System.out.println(ret);
    }

    public static void perm(int cnt) {
        if(cnt == K) {
            for(int i = 0; i < K; i++) {
                Tuple t = order[picked[i]];
                rotate(t.r, t.c, t.s);
            }
            for(int i = 1; i <= N; i++) {
                int sum = 0;
                for(int j = 1; j <= M; j++)
                    sum += arr[i][j];
                ret = Math.min(ret, sum);
            }
            for(int i = 0; i <= N; i++)
                arr[i] = tmp[i].clone();
            return;
        }
        for(int i = 0; i < K; i++) {
            if(chk[i]) continue;
            picked[cnt] = i;
            chk[i] = true;
            perm(cnt + 1);
            chk[i] = false;
        }
    }

    public static void rotate(int r, int c, int s) {
        for(int t = 0; t < s; t++) {
            int p = arr[r - s + t][c - s + t];
            for(int i = 0; i < 2 * s - 2 * t; i++) arr[r - s + t + i][c - s + t] = arr[r - s + t + i + 1][c - s + t];
            for(int i = 0; i < 2 * s - 2 * t; i++) arr[r + s - t][c - s + t + i] = arr[r + s - t][c - s + t + i + 1];
            for(int i = 0; i < 2 * s - 2 * t; i++) arr[r + s - t - i][c + s - t] = arr[r + s - t - i - 1][c + s - t];
            for(int i = 0; i < 2 * s - 2 * t - 1; i++) arr[r - s + t][c + s - t - i] = arr[r - s + t][c + s - t - i - 1];
            arr[r - s + t][c - s + t + 1] = p;
        }
    }
}
