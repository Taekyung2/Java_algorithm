package boj_algorithm._2500;

import java.util.Scanner;

public class _2579_계단오르기 {
	static int N;
	static int[] score = new int[301];
	static int[] cache = new int[301];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i = 1; i <= N; i++)
			score[i] = sc.nextInt();
		cache[0] = 0;
		cache[1] = score[1];
		cache[2] = score[1] + score[2];
		System.out.println(sol(N));
		sc.close();
	}
	
	public static int sol(int n) {
		for(int i = 3; i <= n; i++)
			cache[i] = Math.max(score[i] + cache[i - 2]
						,score[i] + score[i - 1] + cache[i - 3]);
		return cache[n];
	}
}