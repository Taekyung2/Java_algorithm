package boj_algorithm._1000;

import java.util.Scanner;

public class _1008_a나누기b {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double ret = sc.nextDouble() / sc.nextDouble();
		System.out.printf("%.12f", ret);
		sc.close();
	}
}
