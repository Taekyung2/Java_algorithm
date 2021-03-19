package boj_algorithm._1700;

import java.util.*;

public class _1707_이분그래프 {
    static int V, E;
    static ArrayList<Integer>[] adj;
    static int[] chk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        loop:
        for(int t = 1; t <= tc; t++) {
            V = sc.nextInt();
            E = sc.nextInt();
            adj = new ArrayList[V + 1];
            for(int i = 1; i <= V; i++)
                adj[i] = new ArrayList<>();
            chk = new int[V + 1];
            Arrays.fill(chk, -1);
            for (int i = 0; i < E; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                adj[from].add(to);
                adj[to].add(from);
            }
            for(int i = 1; i <= V; i++) {
                if(chk[i] == -1)
                    if(!bfs(i)) {
                        System.out.println("NO");
                        continue loop;
                    }
            }
            System.out.println("YES");
        }
    }

    public static boolean bfs(int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        chk[src] = 0;
        int cnt = 1;
        while(!q.isEmpty()) {
            int s = q.size();
            for (int c = 0; c < s; c++) {
                int cur = q.poll();
                for(int i : adj[cur]) {
                    if(chk[i] != -1 && chk[cur] == chk[i]) return false;
                    if (chk[i] != -1) continue;
                    chk[i] = cnt % 2;
                    q.add(i);
                }
            }
            cnt++;
        }
        return true;
    }
}
