package jungol;

import java.util.Scanner;

public class jungol_hw2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 1, tmp = n;
		do {
			n = tmp * i++;
			if(n < 100)
				System.out.print(n + " ");
		} while(n % 10 != 0);
		sc.close();
	}
}
