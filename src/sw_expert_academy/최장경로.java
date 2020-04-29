package sw_expert_academy;

import java.util.Scanner;

public class 최장경로 {
	public static int N, M, cnt, max;
	public static boolean[] visited;
	public static int[][] adjacent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			max = 1;
			adjacent = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			for(int i = 0; i < M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adjacent[from][to] = 1;
				adjacent[to][from] = 1;
			}
			for(int i = 1; i <= N; i++) {
				cnt = 1;
				visited[i] = true;
				bfs(i);
				visited[i] = false;
			}
			System.out.println("#" + t + " " + max);
		}
		sc.close();
	}
	
	public static void bfs(int curr) {
		for(int next= 1; next <= N; next++) 
			if(!visited[next] && adjacent[curr][next] == 1) {
				visited[next] = true;
				cnt++;
				max = Math.max(max, cnt);
				bfs(next);
				visited[next] = false;
				cnt--;
			}	
	}
}
