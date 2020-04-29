package sw_expert_academy;

import java.util.Scanner;

public class 파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = 0;
			int[][] arr = new int[N + M][N + M];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					arr[i][j]= sc.nextInt();
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++) {
					int sum = 0;
					for(int p = i; p < i + M; p++)
						for(int q = j; q < j + M; q++)
							sum += arr[p][q];
					max = Math.max(max, sum);
				}
			System.out.println("#" + t + " " + max);
		}
		sc.close();
	}
}