package boj_algorithm._14500;

import java.util.Scanner;

public class _14501_퇴사 {
    static int N, ret = 0;
    static int[] t, p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        t = new int[N];
        p = new int[N];
        for(int i = 0; i < N; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        dfs(0, 0);
        System.out.println(ret);
    }

    private static void dfs(int cur, int sum) {
        if(cur >= N) {
           ret = Math.max(ret, sum);
           return;
        }
        if(cur + t[cur] <= N) {
            dfs(cur + t[cur], sum + p[cur]);
        }
        dfs(cur + 1, sum);
    }
}