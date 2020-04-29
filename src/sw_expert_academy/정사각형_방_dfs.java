package sw_expert_academy;

import java.util.Scanner;

public class 정사각형_방_dfs {
	static int N, cnt;
	static int[][] arr;
	static int[] dy = {0,-1,0,1};
	static int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			int ret = 100000, max = 0;
			arr = new int[N][N];
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < N; j++) {
					cnt = 1;
					dfs(new Point(i, j));
					if(max < cnt) {
						max = cnt;
						ret = arr[i][j];
					}
					if(max == cnt && ret > arr[i][j])
						ret = arr[i][j];
				}
			System.out.println("#" + t + " " + ret + " " + max);
		}
		sc.close();
	}
	
	public static void dfs(Point curr) {
		for(int d = 0; d < 4; d++) {
			int ny = curr.y + dy[d], nx = curr.x + dx[d];
			if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
			if(arr[ny][nx] == arr[curr.y][curr.x] + 1) { 
				cnt++;
				dfs(new Point(ny, nx));
			}
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