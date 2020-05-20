package boj_algorithm._2400;

import java.util.Scanner;

public class _2468_안전영역 {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int N;
	static int arr[][];
	static boolean visited[][];
	static int rain;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		int count = 0;
		int max = 0;
		int max_cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				max = Math.max(max, arr[i][j]);
			}
		}
		
		for (int k = 1; k <= max; k++) {
			count = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] >= k && !visited[i][j]) {
						dfs(i, j, k);
						count++;
					}
				}
			}
			max_cnt = Math.max(max_cnt, count);
		}
		System.out.println(max_cnt);

		sc.close();
	}

	public static void dfs(int x, int y, int k) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int NextX = x + dx[i];
			int NextY = y + dy[i];

			if (NextX < 0 || NextY < 0 || NextX >= N || NextY >= N)
				continue;

			if (!visited[NextX][NextY] && arr[NextX][NextY] >= k) {
				dfs(NextX, NextY, k);
			}
		}
	}
}
