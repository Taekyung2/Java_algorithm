package boj_algorithm._15600;

import java.util.Scanner;

public class _15684_사다리조작 {
    static int N, M, H;
    static int[][] ladder;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        ladder = new int[31][11];
        for(int i = 0; i < M; i++) {
            int h = sc.nextInt();
            int to = sc.nextInt();
            ladder[h][to] = 1;
        }
        for(int n = 0; n < 4; n++) {
            if(pick(0, 1, n)) {
                System.out.println(n);
                return;
            }
        }
        System.out.println(-1);
    }

    public static boolean pick(int cur, int idx, int cnt) {
        if(cur == cnt) {
            return chk();
        }

        for(int i = idx; i <= H; i++) {
            for(int j = 1; j < N; j++) {
                if(ladder[i][j] == 1 || ladder[i][j - 1] == 1 || ladder[i][j + 1] == 1) continue;
                ladder[i][j] = 1;
                if(pick(cur + 1, i, cnt))
                    return true;
                ladder[i][j] = 0;
            }
        }
        return false;
    }

    public static boolean chk() {
        for(int i = 1; i < N; i++) {
            int cur = i;
            for(int j = 1; j <= H; j++) {
                if(ladder[j][cur] == 1) cur++;
                else if(ladder[j][cur - 1] == 1) cur--;
            }
            if(cur != i)
                return false;
        }
        return true;
    }
}