package boj_algorithm._16200;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _16234_인구이동 {
	static class nation {
		int y, x;
		
		public nation(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int n, l, r, ret = 0;
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		map = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();
		while(true) {
			visited = new boolean[n][n];
			if(bfs())
				ret++;
			else
				break;
		}
		System.out.println(ret);
	}
	
	public static boolean bfs() {
		boolean chk = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j]) continue;
				Queue<nation> q_bfs = new LinkedList<>();
				Queue<nation> q_cal = new LinkedList<>();
				q_bfs.add(new nation(i, j));
				q_cal.add(new nation(i, j));
				visited[i][j] = true;
				int sum = map[i][j];
				while(!q_bfs.isEmpty()) {
					nation cur = q_bfs.poll();
					for(int d = 0; d < 4; d++) {
						int ny = cur.y + dy[d];
						int nx = cur.x + dx[d];
						if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]) continue;
						int dif = Math.abs(map[ny][nx] - map[cur.y][cur.x]);
						if(l <= dif && dif <= r) {
							nation tmp = new nation(ny, nx);
							q_bfs.add(tmp);
							q_cal.add(tmp);
							visited[ny][nx] = true;
							chk = true;
							sum += map[ny][nx];
						}
					}
				}
				int part = sum / q_cal.size();
				while(!q_cal.isEmpty()) {
					nation n = q_cal.poll();
					map[n.y][n.x] = part;
				}
			}
		}
		return chk;
	}
}