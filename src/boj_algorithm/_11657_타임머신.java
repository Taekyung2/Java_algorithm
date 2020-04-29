package boj_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _11657_타임머신 {
	static class Pair {
		int first, second;
		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	final static int INF = 1000000000;
	static int[] upper;
	static int V, E;
	static ArrayList<Pair>[] adj;
	
	static boolean bellmanFord(int src) {
		upper = new int[V + 1];
		Arrays.fill(upper, INF);
		upper[src] = 0;
		for(int iter = 1; iter <= V; ++iter) {
			for(int here = 1; here <= V; ++here)
				for(int i = 0; i < adj[here].size(); ++i) {
					int there = adj[here].get(i).first;
					int cost = adj[here].get(i).second;
					if(upper[here] != INF && upper[there] > upper[here] + cost) {
						upper[there] = upper[here] + cost;
						if(iter == V) return false;
					}
				}
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		adj = new ArrayList[V + 1];
		for(int i = 0; i <= V; i++) adj[i] = new ArrayList<Pair>();
		for(int i = 0; i < E; i++) {
			int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
			adj[u].add(new Pair(v, w));
		}
		if(bellmanFord(1))
			for(int i = 2; i <= V; i++)
				System.out.println((upper[i] == INF ? -1 : upper[i]));
		else
			System.out.println(-1);
		sc.close();
	}
}
