package jungol;
import java.util.Scanner;

public class jungol_1719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(n > 100 || m <= 0 || m > 4 || (n%2 == 0)) {
			System.out.println("INPUT ERROR!");
			sc.close();
			return;
		} 
		if(m == 1) m1(n);
		else if(m == 2) m2(n);
		else if(m == 3) m3(n);
		else if(m == 4) m4(n);
		sc.close();
	}
	
	static void m1(int n) {
		for(int i = 1; i <= n; i++) {
			if(i <= n / 2 + 1) 
				for(int j = 1; j <= i; j++)
					System.out.print("*");
			else
				for(int j = 0; j <= n - i; j++)
					System.out.print("*");
			System.out.println();
		}
	}
	
	static void m2(int n) {
		for(int i = 1; i <= n; i++) {
			if(i <= n / 2 + 1) {
				for(int j = 0; j <= n / 2 - i; j++)
					System.out.print(" ");
				for(int j = 1; j <= i; j++)
					System.out.print("*");
			}
			else {
				for(int j = n / 2 + 1; j < i; j++)
					System.out.print(" ");
				for(int j = 0; j <= n - i; j++)
					System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void m3(int n) {
		for(int i = 1; i <= n; i++) {
			if(i <= n / 2 + 1 ) {
				for(int j = 1; j < i; j++)
					System.out.print(" ");
				for(int j = 1; j <= n - 2 * (i - 1); j++) 
					System.out.print("*");
				for(int j = 1; j < i; j++)
					System.out.print(" ");
			}
			else {
				for(int j = 0; j < n - i; j++)
					System.out.print(" ");
				for(int j = 0; j < 2 * (i - (n / 2 + 1)) + 1; j++)
					System.out.print("*");
				for(int j = 0; j < n - i; j++)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	static void m4(int n) {
		for(int i = 1; i <= n; i++) {
			if(i <= n / 2 + 1 ) {
				for(int j = 1; j < i; j++)
					System.out.print(" ");
				for(int j = 1; j <= (n / 2 + 1) - (i - 1); j++)
					System.out.print("*");
			}
			else {
				for(int j = 1; j <= n / 2; j++)
					System.out.print(" ");
				for(int j = 1; j <= i - n / 2; j++)
					System.out.print("*");
			}
			System.out.println();
		}
	}
}
