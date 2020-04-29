package boj_algorithm._2800;

import java.util.Scanner;

public class _2804_크로스워드_만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int cross_y = -1, cross_x = -1;
		loop:
		for(int j = 0; j < a.length(); j++)
			for(int i = 0; i < b.length(); i++)
				if(a.charAt(j) == b.charAt(i)) {
					cross_y = i;
					cross_x = j;
					break loop;
				}
		for(int i = 0; i < b.length(); i++) {
			for(int j = 0; j < a.length(); j++) {
				if(j == cross_x) System.out.print(b.charAt(i));
				else if(i == cross_y) System.out.print(a.charAt(j));
				else System.out.print(".");
			}
			System.out.println();
		}
		sc.close();
	}
}