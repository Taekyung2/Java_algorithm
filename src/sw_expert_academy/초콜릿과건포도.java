package sw_expert_academy;

import java.util.Scanner;

public class 초콜릿과건포도 {
	static int[][][][] cache;
	static int cho[][];
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt(); M = sc.nextInt();
			cho = new int[N + 1][M + 1];
			cache = new int[N + 1][M + 1][N + 1][M + 1];
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= M; j++)
					cho[i][j]= sc.nextInt();
			
			for(int i = 1; i <= N; i++)
				for(int j = 1; j < M; j++)
					cho[i][j + 1] += cho[i][j];
			
			for(int i = 1; i < N; i++)
				for(int j = 1; j <= M; j++)
					cho[i + 1][j] += cho[i][j];
			System.out.println("#" + t + " " + sol(1, 1, N, M));
		}
		sc.close();
	}
	
	static int sol(int n, int m, int nl, int ml) {
		if(nl == 1 && ml == 1) return 0;
		int ret = cache[n][m][nl][ml];
		if(ret != 0) return ret;
		ret = Integer.MAX_VALUE;
		int sum = cho[n + nl - 1][m + ml - 1] - cho[n + nl - 1][m - 1] - cho[n - 1][m + ml - 1] + cho[n - 1][m - 1];
		for(int i = 1; i < nl; i++)
			ret = Math.min(ret, sum + sol(n, m, i, ml) + sol(n + i, m, nl - i, ml));
		for(int j = 1; j < ml; j++)
			ret = Math.min(ret,  sum + sol(n, m, nl, j) + sol(n, m + j, nl, ml - j));
		return cache[n][m][nl][ml] = ret;
	}
}