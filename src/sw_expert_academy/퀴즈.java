package sw_expert_academy;

import java.util.Scanner;

public class 퀴즈 {
	final static int MOD = 1000000007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			long sum = 0;
			for(int i = 1; i <= N; i++) {
				sum += pow(i, i);
				sum %= MOD;
			}
			System.out.println("#" + t + " " + sum);
		}
		sc.close();
	}
	
	public static long pow(int x, int n) {
		if(n == 1) return x;
		if(n % 2 == 0) {
			long y = pow(x, n / 2);
			return (y * y) % MOD;
		}
		else {
			long y = pow(x, (n - 1) / 2);
			return (((y * y) % MOD) * x) % MOD;
		}
	}
}