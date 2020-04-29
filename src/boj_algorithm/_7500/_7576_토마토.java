package boj_algorithm._7500;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7576_토마토 {
	static int M, N, cnt = 0;
	static int[][] arr;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];
		Queue<Point> q = new LinkedList<>();
		boolean chk = false;
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 0) chk = true;
				if(arr[i][j] == 1) q.add(new Point(i, j));
				
			}
		if(!chk) {
			System.out.println("0");
			sc.close();
			return;
		}
		
		bfs(q);

		if(all_Ripen())
			System.out.println(cnt - 1);
		else
			System.out.println("-1");
		sc.close();
	}
	
	public static void bfs(Queue<Point> q) {
		while(!q.isEmpty()) {		
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Point now = q.poll();
				for(int d = 0; d < 4; d++) {	
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
					if(arr[ny][nx] == 0) {
						q.add(new Point(ny, nx));
						arr[ny][nx] = 1;
					}
				}
			}
			cnt++;
		}
	}
	
	public static boolean all_Ripen() {
		boolean chk = true;
		loop:
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < M; j++)
				if(arr[i][j] == 0) {
					chk = false;
					break loop;
				}
		return chk;
	}
	
	static class Point {
		int y, x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
