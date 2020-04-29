package boj_algorithm;

import java.util.Scanner;

public class _10951_a더하기b {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a + b);
		}
		sc.close();
	}
}
