package boj_algorithm;

import java.util.Scanner;

public class _3109_빵집 {
	static int R, C, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1};
	static int[] dx = {1, 1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); C = sc.nextInt();
		map = new char[R][C];
		visited = new boolean[R][C];
		cnt = 0;
		for(int i = 0; i < R; i++)
			map[i] = sc.next().toCharArray();
		
		for(int i = 0; i < R; i++) 
			dfs(i, 0);
		
		System.out.println(cnt);
		sc.close();
	}
	
	public static boolean dfs(int y, int x) {
		if(x == C - 1) {
			cnt++;
			return true;
		}
		
		for(int d = 0; d < 3; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == 'x' || visited[ny][nx]) continue;
			visited[y][x] = true;
			if(dfs(ny, nx))
				return true;
		}
		return false;
	}
}
