package boj_algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _11559_puyopuyo {
	static boolean[][] visited;
	static char[][] board;	
	static int cnt;
	static ArrayList<point> list = new ArrayList<point>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		board = new char[12][6];
		for(int i = 0; i < 12; i++)
			board[i] = sc.nextLine().toCharArray();
		int cnt = 0;
		while(true) {
			visited= new boolean[12][6];
			for(int i = 0; i < 12; i++) 
				for(int j = 0; j < 6; j++) 
					if(board[i][j] != '.' && !visited[i][j])
							bfs(new point(i, j));	
			
			if(list.size() == 0) break;
			else {
				cnt++;
				for(int i = 0; i < list.size(); i++)
					board[list.get(i).y][list.get(i).x] = '.'; 
				list.clear();
				down();
			}
		}
		System.out.println(cnt);
		sc.close();
	}
	
	public static void bfs(point curr_p) {
		Queue<point> q = new LinkedList<point>();
		ArrayList<point> list2 = new ArrayList<>();
		q.add(curr_p);
		list2.add(curr_p);
		visited[curr_p.y][curr_p.x] = true; 
		while(!q.isEmpty()) {
			point now = q.poll();
			for(int d = 0; d < 4; d++) {	
				point next = new point(now.y + dy[d], now.x + dx[d]);
				if(next.y < 0 || next.x < 0 || next.y >= 12 || next.x >= 6 || visited[next.y][next.x] || board[next.y][next.x] != board[now.y][now.x]) continue;
				visited[next.y][next.x] = true;
				q.add(next);
				list2.add(next);
			}
		}
		if(list2.size() >= 4)
			for(int i = 0; i  < list2.size(); i++)
				list.add(list2.get(i));
	}
	
	public static void down() {
		for(int i = 0; i < 6; i++) 
			for(int j = 10; j >= 0; j--) 
				for(int k = 11; k > j; k--) 
					if(board[j][i] != '.' && board[k][i] == '.') {
						board[k][i] = board[j][i];
						board[j][i] = '.';
						break;
					}
	}
	
	public static class point {
		int y, x;
		
		public point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}