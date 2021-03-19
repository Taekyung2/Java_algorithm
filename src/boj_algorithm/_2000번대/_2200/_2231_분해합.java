package boj_algorithm._2200;

import java.util.Scanner;

public class _2231_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		for(i = 1; i < n; i++) {
			String str = "" + i;
			int a = i;
			int j = 0;
			while(j < str.length()) {
				a += (str.charAt(j) - '0');
				j++;
			}
			if(n == a) break;
		}
		if(i == n) System.out.println(0);
		else System.out.println(i);
		sc.close();
	}
}
