package sw_expert_academy;

import java.util.*;

public class 오나의여신님 {
	static class Point {
		int y, x;
		char ch;
		public Point(int y, int x, char ch) {
			this.y = y;
			this.x = x;
			this.ch = ch;
		}
	}
	static int n, m, ret;
	static Point D, S;
	static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
	static char[][] map;
	static Queue<Point> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			n = sc.nextInt(); m = sc.nextInt();
			map = new char[n][m];
			q = new LinkedList<Point>();
			ret = 0;
			for(int i = 0; i < n; i++) {
				String str = sc.next();
				for(int j = 0; j < m; j++) {
					char ch = str.charAt(j);
					map[i][j] = ch;
					if(ch == 'D') D = new Point(i, j, 'D');
					else if (ch == 'S') S = new Point(i, j, 'S');
					else if (ch == '*') q.add(new Point(i, j, '*'));
				}
			}
			q.add(S);
			bfs();
			System.out.println("#" + t + " " + (ret == 0 ? "GAME OVER" : ret));
		}
		sc.close();
	}
	
	static void bfs() {
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {	
				Point now = q.poll();
				for(int d = 0; d < 4; d++) {
					int ny = now.y + dy[d], nx = now.x + dx[d];
					if(now.ch == 'S' && ny == D.y && nx == D.x) {
						ret = cnt + 1;
						return;
					}
					if(ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] != '.') continue;
					q.add(new Point(ny, nx, now.ch));
					map[ny][nx] = now.ch;
				}
			}
			cnt++;
		}
	}
}