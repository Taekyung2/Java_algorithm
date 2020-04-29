package sw_expert_academy;

import java.util.Arrays;
import java.util.Scanner;

public class 다항식_계산 {
	final static int MOD = 998244353;
	static int N;
	static Function[] f_list;
	static long[] cache;
	static class Function {
		int t, a, b;
		
		public Function(int t, int a, int b) {
			this.t = t;
			this.a = a;
			this.b = b;
		}	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			f_list = new Function[N + 1];
			for(int i = 2; i <= N; i++) {
				Function f = new Function(sc.nextInt(), sc.nextInt(), sc.nextInt());
				f_list[i] = f;
			}
			int M = sc.nextInt();
			System.out.print("#" + t + " ");
			for(int i  = 0; i < M; i++) {
				cache = new long[N + 1];
				Arrays.fill(cache, -1);
				System.out.print(solve(N, sc.nextInt()) + " ");
			}
			System.out.println();
		}
		sc.close();
	}
	
	public static long solve(int n, int x) {
		if(n == 0) return 1;
		if(n == 1) return x;
		if(cache[n] != -1) return cache[n];
	
		switch(f_list[n].t) {
		case 1 :
			return cache[n] = (solve(f_list[n].a, x) + solve(f_list[n].b, x)) % MOD;
		case 2 :
			return cache[n] = (f_list[n].a * solve(f_list[n].b, x)) % MOD;
		case 3 :
			return cache[n] = (solve(f_list[n].a, x) * solve(f_list[n].b, x)) % MOD;
		default :
			return 0;
		}
	}
}