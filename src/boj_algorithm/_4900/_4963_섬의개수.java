package boj_algorithm._4900;

import java.util.Scanner;

public class _4963_섬의개수 {
	static int w, h;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			int cnt = 0;
			if(w == 0 && h == 0) break;
			arr = new int[h][w];
			visited = new boolean[h][w];
			for(int i = 0; i < h; i++)
				for(int j = 0; j < w; j++)
					arr[i][j] = sc.nextInt();
			for(int i = 0; i < h; i++)
				for(int j = 0; j < w; j++) {
					if(!visited[i][j] && arr[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			System.out.println(cnt);
		}
		sc.close();
	}
	
	public static void dfs(int y, int x) {
		if(y == h && x == w)
			return;
		visited[y][x] = true;
		for(int d = 0; d < 8; d++) {
			int next_y = y + dy[d];
			int next_x = x + dx[d];
			if(next_y < 0 || next_x < 0 || next_y >= h || next_x >= w || arr[next_y][next_x] == 0 || visited[next_y][next_x]) continue;
			dfs(next_y, next_x);
		}
	}
}