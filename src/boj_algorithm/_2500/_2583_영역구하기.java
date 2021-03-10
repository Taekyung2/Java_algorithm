package boj_algorithm._2500;

import java.awt.*;
import java.util.*;

public class _2583_영역구하기 {
    static int M, N, K;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[M][N];
        visited = new boolean[M][N];
        for(int i = 0; i < K; i++) {
            int sx = sc.nextInt(), sy = sc.nextInt(), ex = sc.nextInt(), ey = sc.nextInt();
            for(int y = sy; y < ey; y++)
                for(int x = sx; x < ex; x++)
                    map[y][x] = 1;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 0) {
                    ret.add(bfs(new Point(j, i)));
                    cnt++;
                }
            }
        }
        Collections.sort(ret);
        System.out.println(cnt);
        ret.forEach(x -> System.out.print(x + " "));
    }

    static int bfs(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        visited[p.y][p.x] = true;
        int cnt = 0;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            cnt++;
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d], nx = cur.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= M || nx >= N || visited[ny][nx] || map[ny][nx] != 0) continue;
                visited[ny][nx] = true;
                q.add(new Point(nx, ny));
            }
        }
        return cnt;
    }
}
