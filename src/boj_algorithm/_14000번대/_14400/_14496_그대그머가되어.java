package boj_algorithm._14000번대._14400;

import java.util.*;

public class _14496_그대그머가되어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int N = sc.nextInt(), M = sc.nextInt();
        List<Integer>[] adj = new List[N + 1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] dist = new int[N + 1];
        int ret = 0;
        Queue<Integer> q = new LinkedList<>();
        dist[a] = 1;
        q.add(a);
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == b) {
                ret = dist[cur];
                break;
            }
            for(int next : adj[cur]) {
                if(dist[next] > 0) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }
        System.out.println(ret - 1);
    }
}
