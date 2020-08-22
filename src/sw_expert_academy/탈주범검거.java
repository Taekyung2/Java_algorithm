package sw_expert_academy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈주범검거 {
	public static class Point {
		int y, x;
		
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	 static int N, M, L, result;
	    static int[][] map;
	    static boolean[][] visited;
	    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	    static boolean[][] tunnel= { 
	    		{false, false, false, false}
	          , {true, true, true, true}
	          , {true, false, true, false}
	          , {false, true, false, true}
	          , {true, true, false, false}
	          , {false, true, true, false}
	          , {false, false, true, true}
	          , {true, false, false, true}
	    };
	     
	    
	    public static void bfs(Point p) {
	        Queue<Point> q = new LinkedList<>();
	        visited[p.y][p.x] = true;
	        q.add(p);
	        result++;
	        L--;
	        while(L > 0) {
	            int size = q.size();
	            for (int s = 0; s < size; s++) {
	                Point now = q.poll();
	                 
	                for (int d = 0; d < dir.length; d++) {
	                    if (tunnel[map[now.y][now.x]][d]) {
	                        int ny = now.y + dir[d][0];
	                        int nx = now.x + dir[d][1];
	                         
	                        if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx]) {
	                            if (map[ny][nx] != 0 && tunnel[map[ny][nx]][(d + 2) % 4]) {
	                                visited[ny][nx] = true;
	                                q.add(new Point(ny, nx));
	                                result++;
	                            }
	                        }
	                    }
	                }
	            }
	            L--;
	        }
	    }
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int tc = sc.nextInt();
	        for (int t = 1; t <= tc; t++) {
	            N = sc.nextInt();
	            M = sc.nextInt();
	            int R = sc.nextInt();
	            int C = sc.nextInt();
	            L = sc.nextInt();
	             
	            map = new int[N][M];
	            visited = new boolean[N][M];
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < M; j++) {
	                    map[i][j] = sc.nextInt();
	                }
	            }
	            result = 0;
	            bfs(new Point(R, C));
	            System.out.println("#" + t + " " + result);
	        }
	    }
	     
	      
}