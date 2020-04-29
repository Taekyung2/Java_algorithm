package jungol;

import java.util.Scanner;

public class jungol_hw1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] first = new int[2][4];
		int[][] second = new int[2][4];
		System.out.println("first array");
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 4; j++)
				first[i][j] = sc.nextInt();

		System.out.println("second array");
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				second[i][j] = sc.nextInt();
				System.out.print(first[i][j] * second[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
