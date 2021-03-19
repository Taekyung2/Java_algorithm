package boj_algorithm._17200;

import java.util.Scanner;

public class _17281_야구 {
    static int N, ret = 0;
    static int[][] batter;
    static int[] pick = new int[9];
    static boolean[] chk = new boolean[9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        batter = new int[N][9];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < 9; j++)
                batter[i][j] = sc.nextInt();
        perm(0);
        System.out.println(ret);
    }

    static void perm(int cnt) {
        if(cnt == 9) {
            if(pick[3] == 0) {
                ret = Math.max(ret, game());
            }
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(chk[i]) continue;
            chk[i] = true;
            pick[cnt] = i;
            perm(cnt + 1);
            chk[i] = false;
        }
    }

    static int game() {
        int ans = 0, idx = 0;
        for(int i = 0; i < N; i++) {
            int[] run = new int[3];
            int out = 0;
            while(out < 3) {
                int h = batter[i][pick[idx]];
                if(h == 0) {
                    out++;
                } else {
                    for(int j = 2; j >= 0; j--) {
                        if(run[j] != 0) {
                            if(j + h >= 3) ans++;
                            else run[j + h] = 1;
                            run[j] = 0;
                        }
                    }
                    if(h == 4) ans++;
                    else run[h - 1] = 1;
                }
                idx = (idx + 1) % 9;
            }
        }
        return ans;
    }
}