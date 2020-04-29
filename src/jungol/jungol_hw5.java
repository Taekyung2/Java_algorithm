package jungol;

import java.util.Scanner;

public class jungol_hw5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		if(n1 > n2) {
			int tmp = n2; n2 = n1; n1 = tmp;
		}
		for(int i = n1; i <= n2; i++)
			System.out.print(i + " ");
		sc.close();
	}
}
