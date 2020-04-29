package boj_algorithm._1100;

import java.util.Scanner;

public class _1157_단어공부 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase();
		int[] arr = new int[200];
		int max = 0, cnt = 0, idx = -1;
		for(int i = 0; i < str.length(); i++)
			arr[str.charAt(i)]++;
		
		for(int i = 0; i < arr.length; i++)
			max = Math.max(max, arr[i]);
		
		for(int i = 0; i < arr.length; i++) 
			if(arr[i] == max) {
				idx = i;
				cnt++;
			}
		
		if(cnt == 1) System.out.println((char)idx);
		else	System.out.println("?");
		sc.close();
	}
}
