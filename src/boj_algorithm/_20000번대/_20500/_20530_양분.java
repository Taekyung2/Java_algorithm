package boj_algorithm._20500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _20530_양분 {

    static int N, Q;
    static boolean[] visited, finished, isCycle;
    static int[] parent, ancestor;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        parent = new int[N + 1];
        ancestor = new int[N + 1];
        finished = new boolean[N + 1];
        isCycle = new boolean[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }
        dfs(1, 0);
        Arrays.fill(visited, false);
        for(int i = 1; i < N + 1; i++) {
           if(isCycle[i] && !visited[i]) {
               bfs(i);
           }
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(isCycle[u] && isCycle[v])
                sb.append("2\n");
            else if(ancestor[u] != ancestor[v])
                sb.append("2\n");
            else
                sb.append("1\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            ancestor[cur] = start;

            for(int next : adj[cur]) {
                if(isCycle[next] || visited[next]) continue;
                q.add(next);
            }
        }
    }

    public static void dfs(int cur, int par) {
        visited[cur] = true;
        for(int i = 0; i < adj[cur].size(); i++) {
            int next = adj[cur].get(i);
            if(!visited[next]) {
                parent[next] = cur;
                dfs(next, cur);
            }
            else if(!finished[next] && next != par) {
                denoteCycle(cur, next);
            }
        }
        finished[cur] = true;
    }

    public static void denoteCycle(int cur, int next) {
        isCycle[cur] = true;
        if(cur == next) return;
        denoteCycle(parent[cur], next);
    }
}