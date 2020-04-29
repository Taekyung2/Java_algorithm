package boj_algorithm;

import java.util.Scanner;

public class _10818_최소최대 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = 1000000;
		int max = -1000000;
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			max = Math.max(num, max);
			min = Math.min(num, min);
		}
		System.out.println(min + " " + max);
		sc.close();
	}
}
