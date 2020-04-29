package sw_expert_academy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 정사각형_방 {
	static int N, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dy = {0,-1,0,1};
	static int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			int ret = 100000, max = 0;
			arr = new int[N][N];
			int result[][] = new int[N][N];
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < N; j++) {
					cnt = 0;
					visited = new boolean[N][N];
					bfs(new Point(i, j));
					result[i][j] = cnt;
					max = Math.max(max, cnt);
				}
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < N; j++) 
					if(result[i][j] == max) 
						ret = Math.min(ret, arr[i][j]);
			System.out.println("#" + t + " " + ret + " " + max);
		}
		sc.close();
	}
	
	public static void bfs(Point curr) {
		Queue<Point> q = new LinkedList<>();
		q.add(curr);
		visited[curr.y][curr.x] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Point now = q.poll();
				for(int d = 0; d < 4; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) continue;
					if(arr[now.y][now.x] + 1 == arr[ny][nx]) {
						q.add(new Point(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
			cnt++;
		}
	}
	
	static class Point{
		int y, x;
		Point(int i, int j){
			this.y = i;
			this.x = j;
		}
	}
}