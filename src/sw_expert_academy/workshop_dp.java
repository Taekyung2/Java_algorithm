package sw_expert_academy;

import java.util.Arrays;
import java.util.Scanner;

public class workshop_dp {
	static int[] cache;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cache = new int[N + 1];
		Arrays.fill(cache, -1);
		sol(0);
		System.out.println(cache[N]);
	}
	
	static void sol(int n) {
		if(n > N) return;
		int ret = 0;
		if(cache[n] != -1) ret = cache[n];
		cache[n] = ret + 1;
		sol(n + 1);
		sol(n + 2);
		sol(n + 3);
	}
}