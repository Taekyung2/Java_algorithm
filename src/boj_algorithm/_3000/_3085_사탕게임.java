package boj_algorithm._3000;

import java.util.Scanner;

public class _3085_사탕게임 {
    static char[][] arr;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];
        int[] dy = {0, 1}, dx = {1, 0};
        for(int i = 0; i < N; i++)
            arr[i] = sc.next().toCharArray();
        int ret = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
               for(int d = 0; d < 2; d++) {
                   int ny = i + dy[d], nx = j + dx[d];
                   if(ny >= N || nx >= N) continue;
                   if(arr[i][j] != arr[ny][nx]) {
                       char tmp = arr[i][j];
                       arr[i][j] = arr[ny][nx];
                       arr[ny][nx] = tmp;
                       for(int t = 0; t < N; t++) {
                           ret = Math.max(ret, check(t, 0));
                           ret = Math.max(ret, check(t, 1));
                       }
                       tmp = arr[i][j];
                       arr[i][j] = arr[ny][nx];
                       arr[ny][nx] = tmp;
                   }
               }
            }
        }
        System.out.println(ret);
    }

    static int check(int n, int r) {
        int cnt = 1, fin = 1;
        if(r == 0) {
            for (int t = 0; t < N - 1; t++) {
                if (arr[t][n] == arr[t + 1][n]) cnt++;
                else {
                    fin = Math.max(fin, cnt);
                    cnt = 1;
                }
            }
        } else {
            for (int t = 0; t < N - 1; t++) {
                if (arr[n][t] == arr[n][t + 1]) cnt++;
                else {
                    fin = Math.max(fin, cnt);
                    cnt = 1;
                }
            }
        }
        return Math.max(fin, cnt);
    }
}