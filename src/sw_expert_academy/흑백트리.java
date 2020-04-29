package sw_expert_academy;

import java.util.ArrayList;
import java.util.Scanner;

public class 흑백트리 {
	final static int MOD = 1000000007;
	static boolean[] visited;
	static long[][] cache;
	static ArrayList<ArrayList<Integer>> list;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			list = new ArrayList<>();
			visited = new boolean[N + 1];
			cache = new long[N + 1][2];
			for(int i = 0; i <= N; i++)
				list.add(new ArrayList<>());
			
			for(int i = 0; i < N - 1; i++) {
				int from = sc.nextInt(), to = sc.nextInt();
				list.get(from).add(to);
				list.get(to).add(from);
			}
			long ret = (dfs(1, 0) + dfs(1, 1)) % MOD;
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
	
	public static long dfs(int cur, int color) {
		if(cache[cur][color] != 0) return cache[cur][color];
		long ret = 1;
		visited[cur] = true;
		for(int next : list.get(cur)) {
			if(visited[next]) continue;
			visited[next] = true;
			if(color == 0)	ret *= dfs(next, 1) % MOD;
			else			ret *= (dfs(next, 0) + dfs(next, 1)) % MOD;
			ret %= MOD;
			visited[next] = false;
		}
		return cache[cur][color] = ret;
	}
}
