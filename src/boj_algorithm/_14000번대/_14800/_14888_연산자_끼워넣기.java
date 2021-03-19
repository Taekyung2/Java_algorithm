package boj_algorithm._14800;

import java.util.Scanner;

public class _14888_연산자_끼워넣기 {
	static int N, max, min;
	static int[] number = new int[12], operator = new int[4];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++)
			number[i] = sc.nextInt();
		for(int i = 0; i < 4; i++)
			operator[i] = sc.nextInt();
		
		perm(operator[0], operator[1], operator[2], operator[3], 1, number[0]);
		System.out.println(max);
		System.out.println(min);
		sc.close();
	}
	
	static void perm(int plus, int minus, int mult, int div, int cnt, int ret) {
		if(cnt == N) {
			max = Math.max(ret, max);
			min = Math.min(ret, min);
			return;
		}
		if(plus > 0)	perm(plus - 1, minus, mult, div, cnt + 1, ret + number[cnt]);
		if(minus > 0)	perm(plus, minus - 1, mult, div, cnt + 1, ret - number[cnt]);
		if(mult > 0)	perm(plus, minus, mult - 1, div, cnt + 1, ret * number[cnt]);
		if(div > 0)		perm(plus, minus, mult, div - 1, cnt + 1, ret / number[cnt]);
	}
}