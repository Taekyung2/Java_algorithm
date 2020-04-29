package jungol;

import java.util.Scanner;


public class jungol_1438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] board = new int[100][100];
		int cnt = 0;
		for(int i = 0; i < num; i++) {
			int left = sc.nextInt();
			int down = sc.nextInt();
			for(int y = down; y < down + 10; y++) 
				for(int x = left; x < left + 10; x++) {
					if(y >= 100 || x >= 100) continue;
					board[y][x] = 1;
				}
		}
		
		for(int[] a : board)
			for(int b : a)
				if(b == 1)
					cnt++;
		System.out.println(cnt);
		sc.close();
	}
}
