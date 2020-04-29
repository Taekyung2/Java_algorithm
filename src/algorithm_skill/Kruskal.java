package algorithm_skill;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
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
	
	static int V = 100;
	@SuppressWarnings("unchecked")
	static ArrayList<Pair>[] adj = new ArrayList[100];
	
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++)
			adj[i] = new ArrayList<Pair>();
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