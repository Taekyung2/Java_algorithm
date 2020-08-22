package boj_algorithm._1000;

import java.util.Scanner;

public class _1062_가르침 {
	static int n, k, ret;
	static int[] alpha = new int[51];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			for(int j = 0; j < s.length();j++)
				alpha[i] |= (1 << s.charAt(j) - 'a');
		}
		int x = (1 << 0) | (1 << 2) | ( 1 << 8) | (1 << 13) | (1 << 19);
		for(int i = x; i < (1 << 26); i++) {
			if(bit_cnt(i |= x) != k) continue;
			int cnt = 0;
			for(int j = 0; j < n; j++)
				if((i & alpha[j]) == alpha[j])
					cnt++;
			ret = Math.max(ret, cnt);
		}
		System.out.println(ret);
	}
	
	public static int bit_cnt(int n) {
		int cnt = 0;
		while(n != 0) {
			if(n % 2 != 0) cnt++;
			n /= 2;
		}
		return cnt;
	}
}