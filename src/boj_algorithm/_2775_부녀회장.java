package boj_algorithm;

import java.util.Scanner;

public class _2775_부녀회장 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[][] arr = new int[15][15];
		for(int i = 1; i < 15; i++)
			arr[0][i] = i; 
		
		for(int i = 1; i < 15; i++)
			for(int j = 1; j < 15; j++)
				for(int r = 1; r <= j; r++)
					arr[i][j] += arr[i - 1][r];
		
		for(int t = 1; t <= tc; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(arr[k][n]);
		}
		sc.close();
	}
}