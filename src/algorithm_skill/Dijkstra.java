package algorithm_skill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Dijkstra {
	static class Pair implements Comparable<Pair> {
		int first, second;
		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.first, o.first);
		}
	}
	
	static int V = 100;
	@SuppressWarnings("unchecked")
	static ArrayList<Pair>[] adj = new ArrayList[100];
	
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++)
			adj[i] = new ArrayList<Pair>();
	}
	
	static ArrayList<Integer> dijkstra(int src) {
		ArrayList<Integer> dist = new ArrayList<>(V);
		Collections.fill(dist, Integer.MAX_VALUE);
		dist.set(src, 0);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, 0));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			int here = p.first;
			int cost = -p.second;
			if(dist.get(here) < cost) continue;
			
			for(int i = 0; i < adj[here].size(); ++i) {
				int there = adj[here].get(i).first;
				int nextDist = cost + adj[here].get(i).second;
				
				if(dist.get(there) > nextDist) {
					dist.set(there, nextDist);
					pq.add(new Pair(there, -nextDist));
				}
			}
		}
		return dist;
	}
}