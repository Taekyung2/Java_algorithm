package sw_expert_academy;

import java.util.*;


public class 하나로 {
	static int[] boss;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			boss = new int[N];
			for (int i = 0; i < N; i++)
				boss[i] = i;
			double[][] pos = new double[N][2];
			for (int i = 0; i < 2; i++)
				for (int j = 0; j < N; j++)
					pos[j][i] = sc.nextDouble();
			PriorityQueue<A> q = new PriorityQueue<>();
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					double w = Math.pow(pos[i][0] - pos[j][0], 2) + Math.pow(pos[i][1] - pos[j][1], 2);
					q.add(new A(i, j, w));
				}
			}
			double sum = 0;
			while (!q.isEmpty()) {
				A a = q.poll();
				if (find(a.s) != find(a.e)) {
					union(a.s, a.e);
					sum += a.w;
				}
			}
			System.out.println("#" + tc + " " + Math.round(sum * sc.nextDouble()));
		}
	}
	
	static int find(int a) {
		if (a == boss[a])
			return a;
		return boss[a] = find(boss[a]);
		}
	
	static void union(int a, int b) {
		int ta = find(a), tb = find(b);
		if (ta != tb)
			boss[ta] = tb;
		}
	
	static class A implements Comparable<A> {
		int s, e;
		double w;
		
		public A(int s, int e, double w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(A o) {
			return this.w > o.w ? 1 : -1;
			}
		}
}