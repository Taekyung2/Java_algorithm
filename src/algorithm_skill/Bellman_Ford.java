package algorithm_skill;

import java.util.ArrayList;
import java.util.Collections;

public class Bellman_Ford{
	static class Pair {
		int first, second;
		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	static int V = 100;
	@SuppressWarnings("unchecked")
	static ArrayList<Pair>[] adj = new ArrayList[100];
	
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++)
			adj[i] = new ArrayList<Pair>();
	}
	
	static ArrayList<Integer> bellmanFord(int src) {
		ArrayList<Integer> upper = new ArrayList<Integer>(V);
		Collections.fill(upper, Integer.MAX_VALUE);
		upper.set(src,  0);
		boolean updated = true;
		for(int iter = 0; iter < V; ++iter) {
			updated = false;
			for(int here = 0; here < V; ++here)
				for(int i = 0; i < adj[here].size(); ++i) {
					int there = adj[here].get(i).first;
					int cost = adj[here].get(i).second;
					
					if(upper.get(there) > upper.get(here) + cost) {
						upper.set(there, upper.get(here) + cost);
						updated = true;
					}
				}
			if(!updated) break;
		}
		if(updated) upper.clear();
		return upper;
	}
}