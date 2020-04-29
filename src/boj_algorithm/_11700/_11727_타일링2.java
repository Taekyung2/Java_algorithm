package boj_algorithm._11700;

import java.util.Arrays;
import java.util.Scanner;

public class _11727_타일링2 {
	static int[] cache = new int[1001];
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Arrays.fill(cache, -1);
		cache[0] = 1;
		cache[1] = 3;
		System.out.println(sol(n));
	}
	
	static int sol(int n) {
		if(n <= 1) return 1;
		int ret = cache[n];
		if(ret != -1) return ret;
		return cache[n] = (2 * sol(n - 2) + sol(n - 1)) % 10007;
	}
}