package boj_algorithm._11700;

import java.util.Arrays;
import java.util.Scanner;

public class _11726_타일링 {
	static int[] cache = new int[1001];
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Arrays.fill(cache, -1);
		System.out.println(sol(n));
	}
	
	static int sol(int n) {
		if(n <= 1) return 1;
		int ret = cache[n];
		if(ret != -1) return ret;
		return cache[n] = (sol(n - 2) + sol(n - 1)) % 10007;
	}
}