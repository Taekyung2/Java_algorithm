package boj_algorithm._2600;

import java.util.ArrayList;
import java.util.Scanner;

public class _2644_촌수계산 {
    static int N, a, b, ret = -1;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        int m = sc.nextInt();
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int from = sc.nextInt(), to = sc.nextInt();
            adj[from].add(to);
            adj[to].add(from);
        }
        dfs(a, 0);
        System.out.println(ret == -1 ? -1 : ret);
    }

    static void dfs(int cur, int cnt) {
        if(cur == b) {
            ret = cnt;
            return;
        }
        visited[cur] = true;
        for(int next : adj[cur]) {
            if(visited[next]) continue;
            dfs(next, cnt + 1);
        }
    }
}