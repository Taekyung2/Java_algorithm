package sw_expert_academy;

import java.util.Scanner;

public class 파스칼_삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int[][] tri = new int[N + 1][N + 1];
			tri[0][0] = 1;
			for(int i = 1; i <= N; i++) 
				for(int j = 1; j <= i; j++)
					tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];
			System.out.println("#" + t);
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <=i; j++)
					System.out.print(tri[i][j] + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}
