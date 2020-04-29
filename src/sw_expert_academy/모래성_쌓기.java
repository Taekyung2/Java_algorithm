package sw_expert_academy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 모래성_쌓기 {
	static int N, M, ret;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Point> q;
	static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			ret = 0;
			map = new char[N][M];
			visited = new boolean[N][M];
			q = new LinkedList<Point>();
			for(int i=0; i < N; i++) {
				map[i] = sc.next().toCharArray();
				for(int j=0; j < M; j++) 
					if(map[i][j] == '.') {
						q.add(new Point(i, j));
						visited[i][j] = true;
					}
			}
			
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i = 0; i < size; i++) {
					Point now = q.poll();
					for(int j = 0; j < 8; j++) {
						int ny = now.y + dy[j], nx = now.x + dx[j];
						if(ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] == '.') continue;
						map[ny][nx]--;
						if(map[ny][nx] == '0') {
							map[ny][nx] = '.';
							q.offer(new Point(ny, nx));
							visited[ny][nx] = true;
						}
					}
				}
				if(q.isEmpty()) break;
				ret++;
			}
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}

	static class Point {
		int y, x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
}