package boj_algorithm;

import java.util.Scanner;

public class _8979_올림픽 { 
	static class Country { 
		public int x, y, z; 
		
		public Country (int x, int y, int z) { 
			this.x = x; this.y = y; this.z = z; 
		} 	
	} 
	
	public static void main (String args[]) { 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt(); 
		Country countries[] = new Country[N + 1]; 
		for (int i = 1; i <= N; i++) { 
			int c = sc.nextInt(); 
			int x = sc.nextInt(); 
			int y = sc.nextInt(); 
			int z = sc.nextInt(); 
			countries[c] = new Country(x, y, z); 
		} 
		int result = 1; 
		Country k = countries[K]; 
		for (int i = 1; i <= N; i++) { 
			Country c = countries[i]; 
			if (c.x > k.x || (c.x == k.x && c.y > k.y) || (c.x == k.x && c.y == k.y && c.z > k.z)) 
				result++; 
		} 
		System.out.println(result);
		sc.close();
	} 
}