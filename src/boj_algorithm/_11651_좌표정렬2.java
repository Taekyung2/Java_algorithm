package boj_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class _11651_좌표정렬2 {
	static class Point implements Comparable<Point>{
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if(this.y == o.y) return this.x - o.x;
			return this.y - o.y;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Point[] arr = new Point[n];
		for(int i = 0; i < n; i++)
			arr[i] = new Point(sc.nextInt(), sc.nextInt());
		Arrays.sort(arr);
		for(Point a : arr)
			System.out.println(a.x + " " + a.y);
		sc.close();
	}
}
