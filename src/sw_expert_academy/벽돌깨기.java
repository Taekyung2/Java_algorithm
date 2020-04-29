package sw_expert_academy;

import java.util.Scanner;

public class 벽돌깨기 {
	static int N, W, H, ret;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt(); W = sc.nextInt(); H = sc.nextInt();
			ret = Integer.MAX_VALUE;
			map = new int[H][W];
			for(int i = 0; i < H; i++)
				for(int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();	
			for(int i = 0; i < W; i++)
				perm(0, i);
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
	
	static void perm(int cnt, int np) {
		if(cnt == N) {
			int tmp = count();
			ret = Math.min(ret, tmp);
			return;
		}
		int[][] tmp = new int[H][W];
		for(int i = 0; i < H; i++)
			tmp[i] = map[i].clone();
		
		visited = new boolean[H][W];
		for(int i = 0; i < H; i++)
			if(map[i][np] > 0) {
				explode(i, np);
				break;
			}
		down();
		for(int next = 0; next < W; next++)
			perm(cnt + 1, next);
		map = tmp;
	}
	
	static void down() {
		for(int i = 0; i < W; i++) 
			for(int j = H - 2; j >= 0; j--) 
				for(int k = H - 1; k > j; k--) 
					if(map[j][i] != 0 && map[k][i] == 0) {
						map[k][i] = map[j][i];
						map[j][i] = 0;
						break;
					}
	}

	static int count() {
		int cnt = 0;
		for(int i = 0; i < H; i++)
			for(int j = 0; j < W; j++)
				if(map[i][j] != 0)
					cnt++;
		return cnt;
	}
	
	
	static void explode(int y, int x) {
		if(visited[y][x]) return;
		visited[y][x] = true;
		int cnt = map[y][x] - 1;
		for(int d = 0; d < 4; d++) {
			for(int n = 1; n <= cnt; n++) {
				int ny = y + dy[d] * n, nx = x + dx[d] * n;
				if(ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
				explode(ny, nx);				
			}
		}
		map[y][x] = 0;
	}
}