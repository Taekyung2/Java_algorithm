package boj_algorithm._1700;

import java.util.ArrayList;
import java.util.Scanner;

public class _1786_찾기 {
	static ArrayList<Integer> arr = new ArrayList<>();
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
	
	static void KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		int j = 0;
		for(int i = 0; i < origin.length(); i++) {
			while(j > 0 && origin.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];
			
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length() - 1) {
					arr.add(i - pattern.length() + 1);
					j = pi[j];
				}
				else j++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String T = sc.nextLine();
		String P = sc.nextLine();
		KMP(T, P);
		System.out.println(arr.size());
		for(int a : arr) 
			System.out.print(a + 1 + " ");
	}
}