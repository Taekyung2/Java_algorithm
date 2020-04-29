package jungol;

import java.util.Scanner;

public class jungol_hw3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i = 1; i <= num; i++)
			System.out.print(i + " ");
		sc.close();
	}
}
