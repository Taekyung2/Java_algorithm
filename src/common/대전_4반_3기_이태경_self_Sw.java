package common;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 대전_4반_3기_이태경_self_Sw {
	
	static class Point {
		int y, x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int ret;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			map = new int[10][10];
			visited = new boolean[10][10];
			ret = 0;
			for(int i = 0; i < 10; i++)
				for(int j = 0; j < 10; j++)
					map[i][j] = sc.nextInt();
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(new Point(i, j));
						ret++;
					}
				}
			}
			System.out.println("#" + t + " " + ret);
		}
	}
	
	static public void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		visited[start.y][start.x] = true;
		q.add(start);
		while(!q.isEmpty()) {
			Point now = q.poll();
			visited[now.y][now.x] = true;
			for(int d = 0; d < 8; d++) {
				int ny = now.y + dy[d];
				int nx = now.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= 10 || nx >= 10 || visited[ny][nx] || map[ny][nx] == 0) continue;
				q.add(new Point(ny, nx));
			}
		}
	}
}
