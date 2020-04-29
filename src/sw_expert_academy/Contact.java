package sw_expert_academy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Contact {
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	static int cnt, max;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			int start = sc.nextInt();
			cnt = 0;
			visited = new boolean[101];
			list = new ArrayList[101];
			for(int i = 0; i <= 100; i++) 
				list[i] = new ArrayList<Integer>();		
			for(int i = 0; i < N / 2; i++)
				list[sc.nextInt()].add(sc.nextInt());
			bfs(start);
			System.out.println("#" + t + " " + max);
		}
		sc.close();
	}
	
	public static void bfs(int curr) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(curr);
		visited[curr] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			max = 0;
			for(int s = 0; s < size; s++) {
				int now = q.poll();
				max = Math.max(max, now);
				for(int i = 0; i < list[now].size(); i++) {
					int next = list[now].get(i);
					if(!visited[next]) {
						visited[next] = true;
						q.add(next);
					}
				}
			}
			cnt++;
		}
	}
}