package sw_expert_academy;

import java.util.Scanner;

public class 승현이의_수학공부 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int mod = n - 1;
			String a = sc.next();
			int sum = 0;
			for(int i = a.length() - 1; i >= 0; i--) {
				int tmp = (a.charAt(i) - '0');
				sum += tmp % mod;
				sum %= mod;
			}
			System.out.println("#" + t + " " + sum % mod);
		}
		sc.close();
	}
}
