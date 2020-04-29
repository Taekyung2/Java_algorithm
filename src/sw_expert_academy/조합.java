package sw_expert_academy;

import java.util.Scanner;

public class 조합 {
	private static final int MOD = 1234567891;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt(), r = sc.nextInt();
			long[] dp = new long[n + 1];
			dp[0] = 1;
			for(int i = 1; i <= n; i++)
				dp[i] = (dp[i - 1] * i) % MOD;
			
			long b = (dp[r] * dp[n - r]) % MOD;
			long rb = fermat(b, MOD - 2);
			long ret = (dp[n] * rb) % MOD;
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
		
	static long fermat(long n, long x) {
		if(x == 0) return 1;
		long tmp = fermat(n, x / 2);
		long ret = (tmp * tmp) % MOD;
		if(x % 2 == 0) return ret;
		else return (ret * n) % MOD;
	}
}