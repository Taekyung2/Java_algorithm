package sw_expert_academy;

import java.util.Scanner;

public class 구간합 {
	static String A, B;
	static long[] a, b;
	static long[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			A = sc.next();
			B = sc.next();
			a = new long[A.length()];
			b = new long[B.length()];
			dp = new long[16];
			long ret = 0;
			for(int i = 0; i < A.length(); i++) { 
				a[i] = (int)(A.charAt(A.length() - i - 1) - '0');
				ret += a[i];
			}
			for(int i = 0; i < B.length(); i++) 
				b[i] = (int)(B.charAt(B.length() - i - 1) - '0');
			dp[0] = 0;
			for(int i = 1; i <= 15; i++) 
				dp[i] = i * 45 * (long)Math.pow(10, i - 1);
			ret += sum(b) - sum(a); 
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
	
	static long sum(long[] arr) {
		long tmp = 0;
		long cur = 0;
		for(int i = arr.length - 1; i >= 0; i--) {
			if(i != 0) 
				tmp += arr[i] * dp[i] + sub_sum(arr[i]) * (long)Math.pow(10, i) + cur * arr[i] * (long)Math.pow(10, i);
			else 
				tmp += arr[i] * dp[i] + sub_sum(arr[i] + 1) * (long)Math.pow(10, i) + cur * (arr[i] + 1) * (long)Math.pow(10, i);
			cur += arr[i];
		}
		return tmp;
	}
	
	static long sub_sum(long a) {
		long sum = 0;
		for(long i = 1; i < a; i++)
			sum += i;
		return sum;
	}
}