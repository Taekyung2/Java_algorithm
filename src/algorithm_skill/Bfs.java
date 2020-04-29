package algorithm_skill;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
	static ArrayList<ArrayList<Integer>> adj;
	static boolean[] discovered;
	
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++)
			adj.add(new ArrayList<Integer>());
		discovered = new boolean[100];
	}
	
	ArrayList<Integer> bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> order = new ArrayList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int now = q.poll();
			discovered[now] = true;
			order.add(now);
			for(int i = 0; i < adj.get(now).size(); i++) {
				int there = adj.get(now).get(i);
				if(!discovered[there]) {
					q.add(there);
					discovered[there] = true;
				}
			}
		}
		return order;
	}
}