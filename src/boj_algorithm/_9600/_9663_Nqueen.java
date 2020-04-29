package boj_algorithm._9600;

import java.util.Scanner;

public class _9663_Nqueen {	
	static int N, ret = 0;
	static boolean[] diag1, diag2, col;

	public static void backtracking(int cnt){
		if(cnt == N) {
			ret++;
			return;
		}
		for(int next = 0; next < N; next++) {
			if(col[next] || diag1[cnt + next] || diag2[cnt + N - 1 - next]) continue;
				col[next] = diag1[cnt + next] = diag2[cnt + N - 1 - next] = true;
				backtracking(cnt + 1);
				col[next] = diag1[cnt + next] = diag2[cnt + N - 1 - next] = false;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new boolean[N];
		diag1 = new boolean[2 * N - 1];
		diag2 = new boolean[2 * N - 1];
		backtracking(0); 
		System.out.println(ret);
		sc.close();
	}
}