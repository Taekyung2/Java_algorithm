package jungol;


import java.util.Scanner;

public class jungol_1523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(n > 100 || m <= 0 || m > 3) {
			System.out.println("INPUT ERROR!");
			sc.close();
			return; 
		}
		if(m == 1) m1(n);
		else if(m == 2) m2(n);
		else if(m == 3) m3(n);
		sc.close();
	}
	
	static void m1(int n) {
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	static void m2(int n) {
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= n - i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	static void m3(int n) {
		for(int i = 1; i <= n; i++) {
			for(int x = 0; x < n - i; x++)
				System.out.print(" ");
			for(int y = 0; y < 2 * i - 1; y++)
				System.out.print("*");
			for(int z = 0; z < n - i; z++)
				System.out.print(" ");
			System.out.println();
		}
	}
}
