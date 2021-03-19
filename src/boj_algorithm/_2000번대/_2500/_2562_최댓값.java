package boj_algorithm._2500;

import java.util.Scanner;

public class _2562_최댓값 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0, ret = 0;
		for(int i = 1; i <= 9; i++) {
			int n = sc.nextInt();
			if(n > max) {
				max = n;
				ret = i;
			}
		}
		System.out.println(max);
		System.out.println(ret);
		sc.close();
	}
}
