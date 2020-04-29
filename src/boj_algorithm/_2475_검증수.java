package boj_algorithm;

import java.util.Scanner;

public class _2475_검증수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ret = 0;
		for(int i = 0; i < 5; i++) {
			int a = sc.nextInt();
			ret += (a * a) % 10;
		}
		System.out.println(ret % 10);
		sc.close();
	}
}
