package sw_expert_academy;

import java.util.Scanner;

public class 요리사 {
	static int N, ret;
	static int[][] S;
	static boolean[] used;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			S = new int[N][N];
			ret = Integer.MAX_VALUE;
			used = new boolean[N];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					S[i][j] = sc.nextInt();
			comb(0, 0);
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}	
	
	public static void comb(int cnt, int idx) {
		if(cnt == N / 2) {
			int a = 0, b = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(used[i] && used[j]) a += S[i][j];
					else if(!used[i] && !used[j]) b += S[i][j];
				}
			}
			ret = Math.min(Math.abs(a - b), ret);
			return;
		}
		if(idx == N) return;
		used[idx] = true;
		comb(cnt + 1, idx + 1);
		used[idx] = false;
		comb(cnt, idx + 1);
	}
}