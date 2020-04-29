package sw_expert_academy;

import java.util.Scanner;

public class 달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int dir = 1, max = N;
			int cnt = 1;
			int y = 0, x = -1;
			while(max > 0) {
				for(int i = 0; i < max; i++) {
					x += dir;
					arr[y][x] = cnt++;
				}
				max--;
				
				for(int i = 0; i < max; i++) {
					y += dir;
					arr[y][x] = cnt++;
				}
				dir *= -1;
			}
			System.out.println("#" + t);
			for(int[] a : arr) {
				for(int b : a)
					System.out.print(b + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}
