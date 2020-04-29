package boj_algorithm;

import java.util.Scanner;

public class _2810_컵홀더 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next().replaceAll("LL", "A");
		if(n <= str.length()) System.out.println(n);
		else System.out.println(str.length() + 1);
		sc.close();
	}
}