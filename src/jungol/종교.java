package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class 종교 {
	static int[] disjoint;
	static int[] arr;
	static int n, m, ret;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		disjoint = new int[n + 1];
		arr = new int[n + 1];
		Arrays.fill(arr,  1);
		ret = n;
		for(int i = 1; i <= n; i++) 
			disjoint[i] = i;	
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a, b);	
		}
		System.out.println(ret);
		sc.close();
	}
	
	public static int find(int idx) {
		if(idx == disjoint[idx]) return idx;	
		return disjoint[idx] = find(disjoint[idx]);
	}
	
	public static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		if(p1 != p2) {
			if(arr[p1] >= arr[p2]) disjoint[p2] = p1;	
			else disjoint[p1] = p2;
			ret--;
		}	
	}
}