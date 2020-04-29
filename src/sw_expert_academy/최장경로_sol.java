package sw_expert_academy;

import java.util.Scanner;

public class 최장경로_sol {
	static int N, M, max;
	static int[][] adj;
	static boolean[] visited;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			adj = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			max = 0;
			for(int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a][b] = 1; 
				adj[b][a] = 1;
			}
			for(int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
			System.out.println("#" + t + " " + max);
		}
		sc.close();
	}
	
	static void dfs(int v, int cnt) {
		//더 이상 방문할 노드가 없음
		max = Math.max(max , cnt);
		
		//모든 노드 중에 나와 간선이 존재하고, 아직 방문하지 않은 노드라면 방문
		for(int i = 1; i <= N; i++) {
			if(adj[v][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
