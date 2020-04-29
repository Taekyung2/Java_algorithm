package sw_expert_academy;

import java.util.Scanner;

public class 스도쿠_검증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int N = 9;
		for(int t = 1; t <= tc; t++) {
			int[][] board = new int[N][N];
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < N; j++) 
					board[i][j] = sc.nextInt();
			
			int ret = 1;
			for(int i = 0; i < N; i++) {
				int[] CountNum = new int[10];
				for(int j = 0; j < N; j++) {
					CountNum[board[i][j]]++;
					CountNum[board[j][i]]++;
					CountNum[board[(i / 3) * 3 + (j / 3)][(i % 3) * 3 + (j % 3)]]++;
				}
				for(int k = 1; k <= 9; k++)
					if(CountNum[k] < 3) {
						ret = 0;
						break;
					}
			}
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
}