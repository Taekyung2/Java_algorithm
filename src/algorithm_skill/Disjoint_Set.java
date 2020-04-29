package algorithm_skill;

import java.util.Arrays;

public class Disjoint_Set {
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
