package boj_algorithm._1800;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1857_발레리노 {
	final static int MAXN = 30;
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int m, n, sy, sx, fy, fx;
	static int[][] board = new int[MAXN][MAXN];
	static int[][][][] cache = new int[MAXN][MAXN][MAXN][MAXN];
	static int[][] dist = new int[MAXN][MAXN];
	static long[][] count = new long[MAXN][MAXN];
	static Queue<Pair> q = new LinkedList<>();
	static class Pair {
		int first, second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt(); n = sc.nextInt();
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
				if(board[i][j] == 3) {
					board[i][j] = 0;
					sx = i; sy = j;
				}
				if(board[i][j] == 4) {
					board[i][j] = 0;
					fx = i; fy = j;
				}
			}
		bfs();
		if(dist[fx][fy] == -1) System.out.println(-1);
		else {
			System.out.println(dist[fx][fy] - 1);
			System.out.println(count[fx][fy]);
		}
		sc.close();
	}
	
	static void bfs() {
		int x, y;
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				if(board[i][j] == 0) {
					q.add(new Pair(i, j));
					cache[i][j][i][j] = 1;
					while(!q.isEmpty()) {
						Pair now = q.poll();
						x = now.first;
						y = now.second;
						for(int d = 0; d < 8; d++)
							if(x + dx[d] >= 0 && x + dx[d] < m && y + dy[d] >= 0 && y + dy[d] < n && board[x + dx[d]][y + dy[d]] == 1 && cache[i][j][x + dx[d]][y + dy[d]] == 0) {
								q.add(new Pair(x + dx[d], y + dy[d]));
								cache[i][j][x + dx[d]][y + dy[d]] = 1;
							}
					}
					
					for(x = 0; x < m; x++)
						for(y = 0; y < n; y++)
							if(cache[i][j][x][y] == 1) {
								for(int d = 0; d < 8; d++)
									if(x + dx[d] >= 0 && x + dx[d] < m && y + dy[d] >= 0 && y + dy[d] < n && board[x + dx[d]][y + dy[d]] == 0 && cache[i][j][x + dx[d]][y + dy[d]] == 0)
										cache[i][j][x + dx[d]][y + dy[d]] = 2;
							}
				}
		
		for(int i = 0; i < dist.length; i++) Arrays.fill(dist[i], -1);
		dist[sx][sy] = 0;
		count[sx][sy] = 1;
		q.add(new Pair(sx, sy));
		while(!q.isEmpty()) {
			Pair now = q.poll();
			x = now.first;
			y = now.second;
			
			for(int i = 0; i < m; i++)
				for(int j = 0; j < n; j++)
					if(cache[x][y][i][j] == 2) {
						if(dist[i][j] == -1) {
							dist[i][j] = dist[x][y] + 1;
							count[i][j] = count[x][y];
							q.add(new Pair(i, j));
						}
						else
							if(dist[i][j] == dist[x][y] + 1)
								count[i][j] += count[x][y];
					}
		}
	}
}