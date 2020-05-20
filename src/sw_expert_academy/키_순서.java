package sw_expert_academy;

import java.util.Scanner;

public class 키_순서 {
	static int n, m, d;
	static int[][][] graph;
	static int[][] visited;
	
	public static int dfs(int now) {
		int ret = 1;
		visited[d][now] = 1;
		for (int i = 1; i <= n; i++) 
			if (visited[d][i] == 0 && graph[d][now][i] != 0)
				ret += dfs(i);
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			graph = new int[2][n + 1][n + 1];
			int u = 0, v = 0;
			for(int i = 0; i < m; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				graph[0][u][v] = 1;
				graph[1][v][u] = 1;
			}
			int cnt = 0;
			for(int i = 0; i <= n; i++) {
				visited = new int[2][n + 1];
				d = 0; u = dfs(i);
				d = 1; v = dfs(i);
				if(u + v - 1 == n)
					cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
