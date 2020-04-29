package sw_expert_academy;

import java.util.Scanner;

public class 사랑의_카운슬러 {
	static Point[] arr;
	static int n;
	static long min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			min = Long.MAX_VALUE;
			arr = new Point[n];
			for(int i = 0; i < n; i++) arr[i] = new Point(sc.nextInt(), sc.nextInt());
			sol(0, 0, 0, 0, 0);
			System.out.println("#" + t + " " + min);
		}
		sc.close();
	}
	
	public static void sol(int plus, int minus, int target, long y, long x) {
		if(target == n) {
			min = Math.min(y * y + x * x, min);
			return;
		}
		if(plus < n / 2)
			sol(plus + 1, minus, target + 1, y - arr[target].y, x - arr[target].x);
		if(minus < n / 2)
			sol(plus, minus + 1, target + 1, y + arr[target].y, x + arr[target].x);
	}
	
	
	static class Point {
		long y, x;
		
		public Point(long y, long x) {
			this.y = y;
			this.x = x;
		}
	}
}