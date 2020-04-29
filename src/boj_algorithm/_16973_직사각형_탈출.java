package boj_algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _16973_직사각형_탈출 {
	static class Point {
		int y, x;
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int N, M, H, W, sy, sx, fy, fx, ret = 10000000;
	static int[][] map, dist;
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		dist = new int[N][M];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		H = sc.nextInt(); W = sc.nextInt();
		sy = sc.nextInt() - 1; sx = sc.nextInt() - 1;
		fy = sc.nextInt() - 1; fx = sc.nextInt() - 1;
		for(int i = 0; i < N; i++)
			Arrays.fill(dist[i], -1);
		bfs();
		System.out.println(dist[fy][fx]);
		sc.close();
	}
	
	static boolean check(int y, int x) {
		for(int i = y; i < y + H; i++) {
			if(i < 0 || i >= N || map[i][x] == 1) return false;
			if(x + W - 1 >= M || map[i][x + W - 1] == 1) return false;
		}
		
		for(int i = x; i < x + W; i++) {
			if(i < 0 || i >= M || map[y][i] == 1) return false;
			if(y + H - 1 >= N || map[y + H - 1][i] == 1) return false;
		}
		return true;
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sy, sx));
		dist[sy][sx] = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.y == fy && now.x == fx) return;
			for(int d = 0; d < 4; d++) {
				int ny = now.y + dy[d];
				int nx = now.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 1 || dist[ny][nx] != -1) continue;
				if(!check(ny, nx)) continue;
				dist[ny][nx] = dist[now.y][now.x] + 1;
				q.add(new Point(ny, nx));
			}
		}
	}
}
