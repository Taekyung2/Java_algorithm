package boj_algorithm._14800;

import java.util.Scanner;

public class _14889_스타트와링크 {
    static int N, ret = Integer.MAX_VALUE;
    static int[][] S;
    static boolean[] chk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N][N];
        chk = new boolean[N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }
        pick(0, 0);
        System.out.println(ret);
    }

    private static void pick(int cnt, int cur) {
       if(cnt == N / 2) {
           int t = 0, f = 0;
           for(int i = 0; i < N; i++) {
              for(int j = 0; j < N; j++) {
                  if(chk[i] && chk[j]) t += S[i][j];
                  if(!chk[i] && !chk[j]) f += S[i][j];
              }
           }
           ret = Math.min(ret, Math.abs(t - f));
           return;
       }

       for(int i = cur; i < N; i++) {
           if(!chk[i]) {
               chk[i] = true;
               pick(cnt + 1, i);
               chk[i] = false;
           }
       }
    }
}