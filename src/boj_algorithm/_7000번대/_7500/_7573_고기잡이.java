package boj_algorithm._7500;

import java.util.ArrayList;
import java.util.Scanner;

public class _7573_고기잡이 {
	public static class Point {
		int y, x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int N, I, M, max = 0;
	static ArrayList<Point> list = new ArrayList<Point>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		I = sc.nextInt();
		M = sc.nextInt();
		for(int i = 0; i < M; i++)
			list.add(new Point(sc.nextInt() - 1, sc.nextInt() - 1));
	
		for(int i = 0; i < M; i++)
			for(int j = 0; j < M; j++)
				for(int r = 1; r < I / 2; r++) 
					sol(list.get(i).y, list.get(j).x, r);
		System.out.println(max);
		sc.close();
	}
 
	public static void sol(int y, int x, int dis) {
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			Point tmp = list.get(i);
			if(y <= tmp.y && tmp.y <= y + dis && x <= tmp.x && tmp.x <= x + I / 2 - dis)
				cnt++;
		}
		max = Math.max(max, cnt);
	}
}