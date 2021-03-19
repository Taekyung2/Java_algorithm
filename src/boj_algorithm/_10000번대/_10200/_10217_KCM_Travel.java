package boj_algorithm._10200;

import java.util.*;

public class _10217_KCM_Travel {
    static class Edge implements Comparable<Edge> {
        int to, cost, time;
        Edge(int to, int cost, int time) {
            this.to = to;
            this.cost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt(), ret = -1;
            ArrayList<Edge>[] adj = new ArrayList[N];
            int[][] d = new int[N][M + 1];
            for(int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
                Arrays.fill(d[i], Integer.MAX_VALUE);
            }
            for(int i = 0; i < K; i++)
                adj[sc.nextInt() - 1].add(new Edge(sc.nextInt() - 1, sc.nextInt(), sc.nextInt()));
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(0, M, 0));
            d[0][M] = 0;
            while(!pq.isEmpty()) {
                Edge cur = pq.poll();
                if(d[cur.to][cur.cost] < cur.time) continue;
                if(cur.to == N - 1) {
                    ret = cur.time;
                    break;
                }
                for(Edge next : adj[cur.to]) {
                    int nc = cur.cost - next.cost, nt = d[cur.to][cur.cost] + next.time;
                    if(nc >= 0 && d[next.to][nc] > nt) {
                        d[next.to][nc] = nt;
                        pq.add(new Edge(next.to, nc, nt));
                    }
                }
            }
            System.out.println(ret == -1 ? "Poor KCM" : ret);
        }
    }
}
