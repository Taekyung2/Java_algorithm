package sw_expert_academy;

import java.util.Scanner;

public class 벌꿀채취 {
	static int N, M, C, max;
	static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			max = 0;
			board = new int[N][N];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					board[i][j] = sc.nextInt();
			comb(0, 0, 0, 0);
			System.out.println("#" + t + " " + max);
		}
		sc.close();
	}

	public static void comb(int y, int x, int cnt, int sum) {
		if(cnt == 2) {
			max = Math.max(max, sum);
			return;
		}

		for(int i = y; i < N; i++) {
			for(int j = x; j <= N - M; j++) {
				int tmp = inner_comb(i, j, 0, 0, 0);
				comb(i, j + M, cnt + 1, sum + tmp);
			}
			x = 0;
		}
	}

	public static int inner_comb(int y, int x, int idx, int sum, int cnt) {
		if (cnt > C)
			return 0;
		if (idx >= M)
			return sum;
		return Math.max(inner_comb(y, x, idx + 1, sum + (int)Math.pow(board[y][x + idx], 2), cnt + board[y][x + idx]),
				inner_comb(y, x, idx + 1, sum, cnt));
	}
}