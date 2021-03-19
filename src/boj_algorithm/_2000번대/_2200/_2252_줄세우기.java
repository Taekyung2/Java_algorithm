package boj_algorithm._2200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _2252_줄세우기 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //1≤N≤32,000
		int M = sc.nextInt(); //1≤M≤100,000
		List<Integer>[] adj = new List[N];
		for(int i = 0; i < N; i++)
			adj[i] = new ArrayList<>();
		int[] cnt = new int[N]; //각 학생별로 나보다 작은 녀석의 수
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			adj[a].add(b);
			cnt[b]++;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < N; i++) {
			if( cnt[i] == 0 )
				queue.add(i);
		}
		StringBuilder sb = new StringBuilder();
		while( !queue.isEmpty()) {
			int n = queue.poll();
			sb.append(n+1).append("\n");
			for(int i = 0; i < adj[n].size(); i++) {
				if( --cnt[adj[n].get(i)] == 0 ) {
					queue.add(adj[n].get(i));
				}
			}
		}
		System.out.println(sb);
		sc.close();
	}
}









