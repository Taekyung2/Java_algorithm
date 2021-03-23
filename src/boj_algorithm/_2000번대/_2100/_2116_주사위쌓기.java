package boj_algorithm._2000번대._2100;

import java.util.Scanner;

public class _2116_주사위쌓기 {
    static int N;
    static int[] match = {5, 3, 4, 1, 2, 0};
    static int[][] dice;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dice = new int[N][6];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < 6; j++)
                dice[i][j] = sc.nextInt();
        int ret = 0;
        for(int i = 0; i < 6; i++)
            ret = Math.max(ret, dfs(0, dice[0][i]));
        System.out.println(ret);
    }

    static int dfs(int n, int up) {
        if(n == N) return 0;
        int i, max = -1;
        for(i = 0; i < 6; i++)
            if(dice[n][i] == up)
                break;
        int next = dice[n][match[i]];
        for(int j = 1; j <= 6; j++)
            if(j != up && j != next)
                max = Math.max(max, j);
        return dfs(n + 1, next) + max;
    }
}
