package boj_algorithm._11700;

import java.util.*;

public class _11725_트리의부모찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0; i < N - 1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
            adj[to].add(from);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] discovered = new boolean[N + 1];
        int[] parent = new int[N + 1];
        parent[1] = 1;
        q.add(1);
        discovered[1] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : adj[cur]) {
                if(discovered[next]) continue;
                discovered[next] = true;
                parent[next] = cur;
                q.add(next);
            }
        }
        for(int i = 2; i <= N; i++)
            System.out.println(parent[i]);
    }
}
