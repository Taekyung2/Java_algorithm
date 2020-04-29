package boj_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class _14852_타일링3 {
	static final int MOD = 1000000007;
	static int[] cache1 = new int[1000001];
	static int[] cache2 = new int[1000001];
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Arrays.fill(cache1, -1);
		Arrays.fill(cache2, -1);
		cache1[0] = 1; cache1[1] = 2;
		cache2[0] = 0; cache2[1] = 1;
		System.out.println(sol(n));
		sc.close();
	}
	
	static int sol(int n) {
		int ret = cache1[n];
		if(ret != -1) return ret;
		cache2[n] = ((sol(n - 1) + sol(n - 2)) % MOD + cache2[n - 2]) % MOD;
		return cache1[n] = (sol(n - 2) + (2 * cache2[n]) % MOD) % MOD;
	}
}