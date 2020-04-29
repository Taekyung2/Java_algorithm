package boj_algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _16137_견우와직녀 {
	static class Point {
		int y, x, time;
		
		Point(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	static int n, m;
	static int[][] map;
	static int[][][] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		dist = new int[n][n][20];

		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();
		int ans =  -1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0 && chk(i, j)) {
					map[i][j] = m;
					int now = bfs();
					if(now != -1) {
						if(ans == -1 || ans > now) {
							ans = now;
						}
					}
					map[i][j] = 0;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
	
	static boolean chk(int i, int j) {
		boolean garo = false;
		if(j - 1 >= 0 && map[i][j - 1] == 0) garo = true;
		if(j + 1 < n && map[i][j + 1] == 0) garo = true;
		boolean sero = false;
		if(i - 1 >= 0 && map[i - 1][j] == 0) sero = true;
		if(i + 1 < n && map[i + 1][j] == 0) sero = true;
		return !(garo && sero);
	}
	
	static int bfs() {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				Arrays.fill(dist[i][j], -1);
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0));
		dist[0][0][0] = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(map[now.y][now.x] >= 2 && now.time % map[now.y][now.x] != 0) {
				int nt = (now.time + 1) % map[now.y][now.x];
				if(dist[now.y][now.x][nt] == -1) {
					dist[now.y][now.x][nt] = dist[now.y][now.x][now.time] + 1;
					q.add(new Point(now.y, now.x, nt));
				}
			}
			else {
				for(int d = 0; d < 4; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
						if(map[now.y][now.x] >= 2 && map[ny][nx] >= 2) continue;
						if(map[ny][nx] >= 1) {
							int nt = (dist[now.y][now.x][now.time]+ 1) % map[ny][nx];
							if(dist[ny][nx][nt] == -1) {
								dist[ny][nx][nt] = dist[now.y][now.x][now.time] + 1;
								q.add(new Point(ny, nx, nt));
							}
						}
					}
				}
			}
		}
		return dist[n - 1][n - 1][0];
	}
}
