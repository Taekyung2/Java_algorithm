package boj_algorithm._14900;

import java.util.*;

public class _14938_서강그라운드 {
    static int n, m, r, ret = 0, INF = (int)1e9;
    static int[] item;
    static int[][] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        item = new int[n];
        adj = new int[n][n];
        for(int i = 0; i < n; i++)
            item[i] = sc.nextInt();

        for(int i = 0; i < n; i++) {
            Arrays.fill(adj[i], INF);
            adj[i][i] = 0;
        }

        for(int i = 0; i < r; i++) {
            int from = sc.nextInt() - 1, to = sc.nextInt() - 1, w = sc.nextInt();
            adj[from][to] = w;
            adj[to][from] = w;
        }

        for(int k = 0; k < n; k++)
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++)
                if (adj[i][j] <= m)
                    sum += item[j];
            ret = Math.max(ret, sum);
        }
        System.out.println(ret);
    }
}
