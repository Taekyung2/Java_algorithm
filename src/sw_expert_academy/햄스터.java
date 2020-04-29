package sw_expert_academy;

import java.util.Scanner;

public class 햄스터 {
	static int N, X, M, total;
	static int[] cage, ret;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt(); X = sc.nextInt(); M = sc.nextInt();
			arr = new int[M][3];
			cage = new int[N];
			ret = new int[N];
			for (int i = 0; i < M; i++)
				for (int j = 0; j < 3; j++)
					arr[i][j] = sc.nextInt();
			total = -1;
			dfs(0, 0);
			System.out.print("#"+ t);
			if (total == -1)
				System.out.print(" " + -1);
			else
				for (int a : ret)
					System.out.print(" " + a);
			System.out.println();
		}
		sc.close();
	}
	
	static boolean check() {
		for (int i = 0; i < M; i++) {
			int sum = 0;
			for (int j = arr[i][0] - 1; j < arr[i][1]; j++)
				sum += cage[j];
			
			if (sum != arr[i][2])
				return false;
		}
		return true;
	}

	static void dfs(int cnt, int sum) {
		if (cnt == N) {
			if (check()) {
				if (total < sum) {
					total = sum;
					ret = cage.clone();
				}
			}
			return;
		}
		for (int i = 0; i <= X; i++) {
			cage[cnt] = i;
			dfs(cnt + 1, sum + i);
			cage[cnt] = 0;
		}
	}
}
