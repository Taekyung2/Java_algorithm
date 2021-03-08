package boj_algorithm._1900;

import java.util.Arrays;
import java.util.Scanner;

public class _1976_여행가자 {
    static int N, M, MAX = 100000;
    static int[][] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(adj[i], MAX);
            for (int j = 0; j < N; j++) {
                int tmp = sc.nextInt();
                if(tmp == 1) adj[i][j] = 1;
                if(i == j) adj[i][j] = 0;
            }
        }
        floyd();
        int a = sc.nextInt() - 1;
        boolean ret = true;
        for(int i = 0; i < M - 1; i++) {
            int b = sc.nextInt() - 1;
            if(adj[a][b] == 100000) ret = false;
            a = b;
        }
        System.out.println(ret ? "YES" : "NO");
    }

    static void floyd() {
        for(int k = 0; k < N; k++) {
            for(int i = 0 ; i < N; i++) {
                if(adj[i][k] == 0) continue;
                for(int j = 0; j < N; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
    }
}
