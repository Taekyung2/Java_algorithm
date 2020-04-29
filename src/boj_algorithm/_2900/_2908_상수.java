package boj_algorithm._2900;

import java.util.Scanner;

public class _2908_상수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		String tmp_a = "", tmp_b = "";
		for(int i = 2; i >= 0; i--) {
			tmp_a += (a[i] - '0');
			tmp_b += (b[i] - '0');
		}
		if(tmp_a.compareTo(tmp_b) > 0) System.out.println(tmp_a);
		else System.out.println(tmp_b);
		sc.close();
	}
}
