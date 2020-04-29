package sw_expert_academy;

import java.util.Scanner;

public class 거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println("#" + t + " " + recur(N, M, 1));
		}
		sc.close();
	}
	
	public static int recur(int n, int m, int ret) {
		if(m == 0) return ret;
		return recur(n, m - 1, ret * n);
	}
}
