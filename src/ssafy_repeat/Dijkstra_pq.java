package ssafy_repeat;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_pq {
    static class Edge implements Comparable<Edge> {
        int v, weight;
        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<Edge>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++) {
            adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V];
        Edge[] D = new Edge[V];

        for(int i = 0; i < V; i++) {
            if(i == 0) {
                D[i] = new Edge(i, 0);
            }
            else {
                D[i] = new Edge(i, Integer.MAX_VALUE);
            }
            pq.add(D[i]);
        }
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            for(Edge next : adj[edge.v]) {
                if(!check[next.v] && D[next.v].weight > D[edge.v].weight + next.weight) {
                    D[next.v].weight = D[edge.v].weight + next.weight;
                    pq.remove(D[next.v]);
                    pq.add(D[next.v]);
                }
            }
        }
    }
}
