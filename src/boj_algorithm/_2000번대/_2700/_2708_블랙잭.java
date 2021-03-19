package boj_algorithm._2700;

import java.util.Scanner;

public class _2708_블랙잭 {
	static int n, m, ret;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		ret = 0;
		arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		comb(0, 0, 0);
		System.out.println(ret);
		sc.close();
	}
	
	static void comb(int cnt, int idx, int sum) {
		if(sum > m) return;
		if(cnt == 3) {
			ret = Math.max(ret,  sum);
			return;
		}
		if(idx == n) return;
		
		comb(cnt + 1, idx + 1, sum + arr[idx]);
		comb(cnt, idx + 1, sum);
	}
}
