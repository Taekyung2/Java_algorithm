package boj_algorithm._16900;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _16985_maaaaze {
    static int[][][][] maze = new int[5][4][5][5];
    static int[] rotate_arr = new int[5];
    static int[] order_arr = new int[5];
    static boolean[] visited = new boolean[5];
    static int ret = Integer.MAX_VALUE;   
    static int[] dz = { 0, 0, 0, 0, 1, -1 };
    static int[] dy = { -1, 1, 0, 0, 0, 0 };
    static int[] dx = { 0, 0, -1, 1, 0, 0 };
    
    static class Point {
    	int z, y, x, dist;
    	
    	public Point(int z, int y, int x, int dist) {
    		this.z = z;
    		this.y = y;
    		this.x = x;
    		this.dist = dist;
    	}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    maze[k][0][i][j] = sc.nextInt();
                }
            }
            rotate(k);
        }
        perm_rotate(0);
        if (ret == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ret);
    }

    private static void rotate(int k) {
    	for (int d = 1; d < 4; d++) {
    		for (int i = 0; i < 5; i++) {
    			for (int j = 0; j < 5; j++) {
    				maze[k][d][j][4 - i] = maze[k][d - 1][i][j];
    			}
    		}
    	}
    }
    
    private static void perm_rotate(int cnt) {
        if (cnt == 5) {
            perm_order(0);
            return;
        }
        for (int i = 0; i < 4; i++) {
            rotate_arr[cnt] = i;
            perm_rotate(cnt + 1);
        }
    }

    private static void perm_order(int cnt) {
        if (cnt == 5) {
            bfs();
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order_arr[cnt] = i;
                perm_order(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static void bfs() {
        int[][][] tmp = new int[5][5][5];
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 5; i++) {
            		tmp[k][i] = maze[order_arr[k]][rotate_arr[k]][i].clone();
            }
        }
        if (tmp[0][0][0] != 1 || tmp[4][4][4] != 1)
            return;

        Queue<Point> q = new LinkedList<>();
        boolean visited[][][] = new boolean[5][5][5];
        q.add(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.dist >= ret)
                return;
            if (cur.z == 4 && cur.y == 4 && cur.x == 4) {
                if (ret > cur.dist)
                    ret = cur.dist;
                return;
            }
            for (int d = 0; d < 6; d++) {
                int nz = cur.z + dz[d], ny = cur.y + dy[d], nx = cur.x + dx[d];
                if (nz >= 0 && nz < 5 && ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && !visited[nz][ny][nx] && tmp[nz][ny][nx] == 1) {
                    q.add(new Point(nz, ny, nx, cur.dist + 1));
                    visited[nz][ny][nx] = true;
                }
            }
        }
    }
}