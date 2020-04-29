package sw_expert_academy;

import java.util.Scanner;

public class 수지의_수지맞는_여행 {
	static int R, C, ret;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			R = sc.nextInt();
			C = sc.nextInt();
			map = new int[R][C];
			ret = 0;
			for(int i = 0; i < R; i++) {
				String str = sc.next();
				for(int j = 0; j < C; j++)
					map[i][j] = (int)(str.charAt(j) - 'A');
			}
			dfs(0, 0, 1, (1 << map[0][0]));
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
	
	public static void dfs(int y, int x, int cnt, int bit) {
		if(ret >= 26) return;
		ret = Math.max(ret,  cnt);
		for(int d = 0; d < 4; d++) {
			int ny = y + dy[d], nx = x + dx[d];
			if(ny < 0 || nx < 0 || ny >= R || nx >= C || (bit & (1 << map[ny][nx])) != 0) continue;
			dfs(ny, nx, cnt + 1, bit | (1 << map[ny][nx]));
		}
	}
}
