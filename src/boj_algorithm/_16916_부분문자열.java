package boj_algorithm;

import java.util.Scanner;

public class _16916_부분문자열 {
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for(int i = 1; i < pattern.length(); i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];
			
			if(pattern.charAt(i) == pattern.charAt(j))
				pi[i] = ++j;	
		}
		return pi;
	}
	
	static boolean KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		int j = 0;
		for(int i = 0; i < origin.length(); i++) {
			while(j > 0 && origin.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];
			
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length() - 1) {
					return true;
				}
				else j++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		String P = sc.nextLine();
		if(KMP(S, P)) System.out.println(1);
		else System.out.println(0);
	}
}
