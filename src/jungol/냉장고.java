package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class 냉장고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		chem[] arr = new chem[n];
		int cnt = 1, idx = 0;
		for(int i = 0; i < n; i++) 
			arr[i] = new chem(sc.nextInt(), sc.nextInt());
		Arrays.sort(arr);
		for(int i = 1; i < n; i++) {
			if(arr[idx].high < arr[i].low) {
				cnt++;
				idx = i;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
	
	public static class chem implements Comparable<chem> {
		int low, high;
		
		public chem(int low, int high) {
			this.low = low;
			this.high = high;
		}
		
		@Override
		public int compareTo(chem o) {
			// TODO Auto-generated method stub
			return this.high - o.high;
		}
	}
}
