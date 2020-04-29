package sw_expert_academy;

import java.util.ArrayList;
import java.util.Scanner;

public class 서로소_집합 {
	static int[] disjoint;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			disjoint = new int[n + 1];
			for(int i = 1; i <= n; i++)
				disjoint[i] = i;
			ArrayList<Integer> q = new ArrayList<>();
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				if(a == 0)
					union(b, c);
				else {
					if(find(b) == find(c)) q.add(1);
					else q.add(0);
				}
			}
			System.out.print("#" + t + " ");
			for(int a : q)
				System.out.print(a);
			System.out.println();
		}
		sc.close();
	}
	
	public static int find(int idx) {
		if(idx == disjoint[idx]) {
			return idx;
		}
		return disjoint[idx] = find(disjoint[idx]);
	}
	
	public static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		if(p1 != p2) {
			disjoint[p1] = p2;
		}
	}
}