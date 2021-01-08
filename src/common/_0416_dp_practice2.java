package common;

import java.util.Arrays;

public class _0416_dp_practice2 {
	public static void main(String[] args) {
		// 1차원 배열에 업데이트 해서 동전 거스름돈 개수를 저장해보자
		int n = 8;
		int[] c = new int[n + 1];
		
		for(int i = 0; i < c.length; i++) {
			c[i] = i; // 1원짜리 필요한 개수 
		}
		System.out.println(Arrays.toString(c));
		// 1, 4원 동전을 모두 고려
		
		for(int i = 4; i < c.length; i++) {
		// c[i] = 1원짜리 동전만 고려한 최소 개수
		// c[i - 4] + 1 = 1원, 4원짜리 동전 고려한 최소 개수 
			if(c[i] > c[i - 4] + 1) {
				c[i] = c[i - 4] + 1;
			}
		}
		System.out.println(Arrays.toString(c));
		
		// 1, 4, 6원 동전을 모두 고려 
		for(int i = 6; i < c.length; i++) {
			if(c[i] > c[i - 6] + 1) {
				c[i] = c[i - 6] + 1;
			}
		}
		System.out.println(Arrays.toString(c));
		
		System.out.println(c[n]);
	} // eom
} // eoc