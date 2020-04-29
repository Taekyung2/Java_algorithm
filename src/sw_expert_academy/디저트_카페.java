package sw_expert_academy;

import java.util.Scanner;

public class 디저트_카페 {
	static int N, ret;
	static int[] dy = {1, 1, -1, -1}, dx = {1, -1, -1, 1};
	static boolean[] dessert;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			dessert = new boolean[101];
			ret = -1;
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			for(int i = 0; i < N - 2; i++) 
				for(int j = 1; j < N - 1; j++) {
					dessert[map[i][j]] = true;
					dfs(i, j, i, j, 0, 1);
					dessert[map[i][j]] = false;
				}
			if(ret < 4) ret = -1;
			System.out.println("#" + t + " " + ret);
		}	
		sc.close();
	}
	
	static void dfs(int y, int x, int cur_y, int cur_x, int dir, int sum) {
		for(int d = dir; d < 4; d++) {
			int ny = cur_y + dy[d], nx = cur_x + dx[d];
			if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
			if(ny == y && nx == x) {
				ret = Math.max(ret, sum);
				return;
			}
			if(!dessert[map[ny][nx]]) {
				dessert[map[ny][nx]] = true;
				dfs(y, x, ny, nx, d, sum + 1);
				dessert[map[ny][nx]] = false;
			}
		}
	}
}