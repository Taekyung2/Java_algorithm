package sw_expert_academy;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		for(int t = 1; t <= 10; t++) {
			sc.nextInt();
			int max = 0, diag_sum1 = 0, diag_sum2 = 0;
			for(int i = 0; i < 100; i++)
				for(int j = 0; j < 100; j++)
					arr[i][j] = sc.nextInt();
			for(int i = 0; i < 100; i++) {
				int col_sum = 0, row_sum = 0; 
				for(int j = 0; j < 100; j++) {
					col_sum += arr[i][j];
					row_sum += arr[j][i];
					if(i == j) diag_sum1 += arr[j][i];
					if(i + j == 99)	diag_sum2 += arr[j][i];
				}
				max = Math.max(max, Math.max(col_sum, row_sum));
			}
			max = Math.max(max,  Math.max(diag_sum1, diag_sum2));
			System.out.println("#" + t + " " + max);
		}
		sc.close();
	}
}