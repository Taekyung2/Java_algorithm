package sw_expert_academy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 내전경기 {
	static int[][] adj;
	static boolean[] visited;
	static int[] team;
	static HashMap<String, Integer> m;
	static String ret;
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int tc = sc.nextInt();
    	for(int t = 1; t <= tc; t++) {
    		int k = sc.nextInt();
    		m = new HashMap<>();
    		adj = new int[200][200];
    		visited = new boolean[200];
    		team = new int[200];
    		ret = "Yes";
    		for(int i = 0; i < k; i++) {
    			String a = sc.next(), b = sc.next();
    			if(!m.containsKey(a)) m.put(a, m.size()); 
    			if(!m.containsKey(b)) m.put(b, m.size());
    			adj[m.get(a)][m.get(b)] = 1;
    			adj[m.get(b)][m.get(a)] = 1;
    		}
    		for(int i = 0; i < m.size(); i++) 
    			if(!visited[i]) bfs(i);
    		
    		System.out.println("#" + t + " " + ret);
    	}
    	sc.close();
    }
    
    static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		team[start] = 1;
		q.add(start);
		while(!q.isEmpty()) {
			int now = q.poll();
			visited[now] = true;
			for(int next = 0; next < m.size(); next++) {
				if(visited[next]) continue;
				if(adj[now][next] == 1) {
					if(team[now] == team[next]) {
						ret = "No";
						return;
					}
					team[next] = team[now] * -1;
					q.add(next);	
				}
			}
		}
    }
}