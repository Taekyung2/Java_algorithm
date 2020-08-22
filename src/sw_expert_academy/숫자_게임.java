package sw_expert_academy;

import java.util.HashMap;
import java.util.Scanner;

public class 숫자_게임 {
	static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int cnt = game(n);
			System.out.println("#" + t + " " + cnt);
		}
		sc.close();
	}
	
	public static int game(int n) {
		//n이 10 미만이면 리턴 0 
		if(n < 10) return 0;
		int max = 0;
		String s = "" + n;
		int len = s.length() - 1;
		/*
		 * 123		0 	: 안쪼갠 경우 
		 * 1 23		1 	: 첫번째 위에서 숫자를 쪼갠다
		 * 12 3		10 	: 두번째 위에서 숫자를 쪼갠다 
		 * 1 2 3 	11 	: 첫번째 두번째 위에서 숫자를 쪼갠다 
		 */
		//부분 집합을 이용해서 1 위치에서 숫자를 쪼갠 후 곱한다 
		for(int i = 1, size = 1 << len; i < size; i++) {
			int num = s.charAt(0) - '0';
			int mul = 1;
			for(int j = len - 1; j >= 0; j--) {
				if((i & (1 << j)) == 0) {
					num = num * 10 + s.charAt(j + 1) - '0';
				} else {
					mul *= num;
					num = s.charAt(j + 1) - '0';
				}
			}
			mul *= num;
			int cnt = 0;
			if(cache.containsKey(mul)) {
				cnt = cache.get(mul);
			} else {
				cnt = game(mul);
				cache.put(mul, cnt);
			}
			max = Math.max(max, cnt);
		}
		return max + 1;
	}
}