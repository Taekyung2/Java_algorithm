package boj_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class _1197_최소스패닝트리 {
	static class Disjoint_Set {
		int[] parent, rank;
		
		public Disjoint_Set(int n) {
			parent = new int[n];
			rank = new int[n];
			for(int i = 0; i < n; i++)
				parent[i] = i;
			Arrays.fill(rank,  1);
		}
		
		public int find(int u) {
			if(u == parent[u]) return u;
			return parent[u] = find(parent[u]);
		}
		
		public void merge(int u, int v) {
			u = find(u); v = find(v);
			if(u == v) return;
			if(rank[u] > rank[v]) {
				int tmp = v;
				v = u;
				u = tmp;
			}
			parent[u] = v;
			if(rank[u] == rank[v]) ++rank[v];
		}
	}

	
	static class Pair {
		int first, second;
		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int cost, from, to;
		
		public Edge(int cost, int from, int to) {
			this.cost = cost;
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static int V, E;
	static ArrayList<Pair>[] adj;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		adj = new ArrayList[V];
		for(int i = 0; i < V; i++) adj[i] = new ArrayList<Pair>();
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			int weight = sc.nextInt();
			adj[from].add(new Pair(to, weight));
			adj[to].add(new Pair(from, weight));
		}
		
		System.out.println(kruskal(new ArrayList<Pair>()));
	}
	
	static int kruskal(ArrayList<Pair> selected) {
		int ret = 0;
		selected.clear();
		ArrayList<Edge> edges = new ArrayList<>();
		for(int u = 0; u < V; u++)
			for(int i = 0; i < adj[u].size(); i++) {
				int v = adj[u].get(i).first;
				int cost = adj[u].get(i).second;
				edges.add(new Edge(cost, u, v));
			}
		
		Collections.sort(edges);
		Disjoint_Set sets = new Disjoint_Set(V);
		for(int i = 0; i < edges.size(); i++) {
			int cost = edges.get(i).cost;
			int u = edges.get(i).from;
			int v = edges.get(i).to;
			if(sets.find(u) == sets.find(v)) continue;
			sets.merge(u, v);
			selected.add(new Pair(u, v));
			ret += cost;
		}
		return ret;
	}
}
