package boj_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class _8979_sol_올림픽 {
	static int K;
	static class Nation implements Comparable<Nation> {
		int nNum, gold, silver, copper;

		public Nation(int nNum, int gold, int silver, int copper) {
			this.nNum = nNum;
			this.gold = gold;
			this.silver = silver;
			this.copper = copper;
		}
		
		@Override
		public int compareTo(Nation o) {
			if(this.gold != o.gold)
				return o.gold - this.gold;
			else if(this.silver != o.silver) 
				return o.silver - this.silver;
			else if(this.copper != o.copper)
				return o.copper - this.copper;
			return 0;
		}
		
		@Override
		public boolean equals(Object obj) {
			Nation o = (Nation)obj;
			return (this.gold == o.gold && this.silver == o.silver && this.copper == o.copper);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Nation nations[] = new Nation[N];
		for(int i = 0; i < N; i++) 
			nations[i] = new Nation(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		Arrays.sort(nations);
		for(int i = 0; i < N; i++) {
			Nation nation = nations[i];
			if(nation.nNum == K) {
				for(int j = 0; j <= i; j++) {
					if(nation.equals(nations[j])) {
						System.out.println(j + 1);
						sc.close();
						return;
					}
				}
			}
		}
		sc.close();
	}
}
