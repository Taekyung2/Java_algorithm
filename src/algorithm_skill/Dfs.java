package algorithm_skill;

import java.util.ArrayList;
import java.util.Arrays;

public class Dfs {
	static ArrayList<ArrayList<Integer>> adj;
	static boolean[] visited;
	
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++) 
			adj.add(new ArrayList<Integer>());
		visited = new boolean[100];
	}
	
	static void dfs(int curr) {
		visited[curr] = true;
		for(int next = 0; next < adj.get(curr).size(); next++) {
			int there = adj.get(curr).get(next);
			if(!visited[there])
				dfs(there);
		}
	}
	
	static void dfsAll() {
		Arrays.fill(visited, false);
		for(int i = 0; i < adj.size(); i++)
			if(!visited[i])
				dfs(i);
	}
}

//인접 리스트를 사용한 dfs 구현