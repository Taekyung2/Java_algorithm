package boj_algorithm._11600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _11657_타임머신 {
	static class Edge {
		int to, weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	final static int INF = 1000000000;
	static long[] upper;
	static int V, E;
	static ArrayList<Edge>[] adj;
	
	static boolean bellmanFord(int src) {
		upper = new long[V + 1];
		Arrays.fill(upper, INF);
		upper[src] = 0;
		for(int iter = 1; iter <= V; ++iter) {
			boolean chk = false;
			for(int here = 1; here <= V; ++here)
				for(int i = 0; i < adj[here].size(); ++i) {
					int there = adj[here].get(i).to;
					int cost = adj[here].get(i).weight;
					if(upper[here] != INF && upper[there] > upper[here] + cost) {
						upper[there] = upper[here] + cost;
						chk = true;
						if(iter == V) return false;
					}
				}
			if(!chk) return true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		adj = new ArrayList[V + 1];
		for(int i = 0; i <= V; i++) adj[i] = new ArrayList<Edge>();
		for(int i = 0; i < E; i++) {
			int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
			adj[u].add(new Edge(v, w));
		}
		if(bellmanFord(1))
			for(int i = 2; i <= V; i++)
				System.out.println((upper[i] == INF ? -1 : upper[i]));
		else
			System.out.println(-1);
		sc.close();
	}
}