package boj_algorithm;

import java.util.Scanner;

public class _10775_공항 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		boolean[] arr = new boolean[n + 1];
		int air = sc.nextInt();
		int i, j;
		for(i = 1; i <= air; i++) {
			int target = sc.nextInt();
			for(j = target; j >= 1; j--) {
				if(!arr[j]) {
					arr[j] = true;
					cnt++;
					break;
				}
			}
			if(j == 0) {
				break;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}