package sw_expert_academy;

import java.util.Scanner;

public class 최적_경로 {
	public static int min, N;
	public static boolean[] visited;
	public static point[] points;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			min = Integer.MAX_VALUE;
			visited = new boolean[N + 2];
			points = new point[N + 2];
			for(int i = 0; i < N + 2; i++)
				points[i] = new point(sc.nextInt(), sc.nextInt());
			for(int i = 2; i < N + 2; i++) {
				visited[i] = true;
				backtrack(i, 0, cal(0, i));
				visited[i] = false;
			}
			System.out.println("#" + t + " " + min);
		}
		sc.close();
	}
	
	public static void backtrack(int curr, int idx, int ret) {
		if(ret >= min) return;
		if(idx == N - 1) {
			min = Math.min(min,  ret + cal(curr, 1));
			return;
		}
		
		for(int next = 2; next < N + 2; next++) {
			if(visited[next]) continue;
			visited[next] = true;
			backtrack(next, idx + 1, ret + cal(curr, next));
			visited[next] = false;
		}
	}
	
	public static int cal(int a, int b) {
		return Math.abs(points[a].y - points[b].y) + Math.abs(points[a].x - points[b].x);
	}
	
	public static class point {
		int y, x;
		public point(int x, int y) {
			this.y = y;
			this.x = x;
		}
	}
}