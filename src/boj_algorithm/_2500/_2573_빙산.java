package boj_algorithm._2500;

import java.util.*;

public class _2573_빙산 {

    static class Point {
        int y, x, c;

        Point(int y, int x, int c) {
            this.y = y;
            this.x = x;
            this.c = c;

        }
    }
    static int N, M, cnt = 0;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] discovered;
    static Queue<Point> remove = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] != 0) cnt++;
            }
        int ret = 0;
        while(bfs() == cnt && cnt > 0) {
            while(!remove.isEmpty()) {
                Point r = remove.poll();
                map[r.y][r.x] -= r.c;
                if(map[r.y][r.x] <= 0) {
                    map[r.y][r.x] = 0;
                    cnt--;
                }
            }
            ret++;
        }
        System.out.println(cnt == 0 ? 0 : ret);
    }

    static Point find() {
        for(int i = 1; i < N - 1; i++)
            for(int j = 1; j < M - 1; j++)
                if(map[i][j] != 0)
                    return new Point(i, j, 0);
        return null;
    }

    static int bfs() {
        Point s = find();
        if(s == null) return 0;
        int count = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(s);
        discovered = new boolean[N][M];
        discovered[s.y][s.x] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            count++;
            int sum = 0;
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d], nx = cur.x + dx[d];
                if(map[ny][nx] == 0) sum++;
                if(ny < 1 || nx < 1 || ny > N - 1 || nx > M - 1 || discovered[ny][nx] || map[ny][nx] == 0) continue;
                discovered[ny][nx] = true;
                q.add(new Point(ny, nx, 0));
            }
            remove.add(new Point(cur.y, cur.x, sum));
        }
        return count;
    }
}