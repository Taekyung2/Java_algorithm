package sw_expert_academy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 방향전환_sol {
	static int sx, sy, fx, fy;
	static class Point {
		int x, y, cnt;
		boolean dir;
		
		public Point(int x, int y, int cnt, boolean dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			sx = sc.nextInt() + 100; sy = sc.nextInt() + 100;
			fx = sc.nextInt() + 100; fy = sc.nextInt() + 100;
			
			//BFS 탐색을 위한 Queue 자료구조 준비
			Queue<Point> queue = new LinkedList<>();
			//방문 체크를 위한 방문 체크 변수 준비
			boolean[][][] visited = new boolean[201][201][2];
			//시작점을 큐에 삽입
			queue.add(new Point(sx, sy, 0, true));
			queue.add(new Point(sx, sy, 0, false));
			//첫 시작점을 현재 위치로, 다음 이동을 가로로 이동할 수 있는 상태
			//첫 시작점을 현재 위치로, 다음 이동을 세로로 이동할 수 있는 상태
			//큐에 이미 삽입된 상태에 대해서는 방문 체크
			visited[sx][sy][0] = true;
			visited[sx][sy][1] = true;
			
			int[] dx = {0, 0, 1, -1};
			int[] dy = {1, -1, 0, 0};
			
			//큐가 빌 때까지 상태를 탐색
			while(!queue.isEmpty()) {
				Point point = queue.poll();
				if(point.x == fx && point.y == fy) {
					System.out.println("#" + t + " " + point.cnt);
					break;
				}
				if(point.dir) {
					for(int d = 0; d < 2; d++) {
						int nx = point.x + dx[d];
						int ny = point.y + dy[d];
						if(nx < 0 || ny < 0 || nx > 200 || ny > 200 || visited[nx][ny][0]) continue;
						queue.add(new Point(nx, ny, point.cnt + 1, !point.dir));
						visited[nx][ny][0] = true;
					}
				}
				else {
					for(int d = 2; d < 4; d++) {
						int nx = point.x + dx[d];
						int ny = point.y + dy[d];
						if(nx < 0 || ny < 0 || nx > 200 || ny > 200 || visited[nx][ny][1]) continue;
						queue.add(new Point(nx, ny, point.cnt + 1, !point.dir));
						visited[nx][ny][1] = true;
					}
				}
			}
		}
		sc.close();
	}
}
