package boj_algorithm._2100;

import java.util.*;

public class _2151_거울설치 {
    static char[][] map;
    static int N, sx = -1, sy, ex, ey, ret = Integer.MAX_VALUE;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int[][] mirror = {{1, 0, 3, 2}, {3, 2, 1, 0}};
    static int[][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        visited = new int[N][N][4];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
                if(map[i][j] == '#') {
                    if(sx == -1) {
                        sy = i; sx = j;
                    } else {
                        ey = i; ex = j;
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int d = 0; d < 4; d++)
            q.add(new int[]{sy, sx, d, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == ey && cur[1] == ex) {
                ret = Math.min(ret, cur[3]);
                continue;
            }
            int ny = cur[0] + dy[cur[2]], nx = cur[1] + dx[cur[2]];
            if(ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == '*') continue;
            if(map[ny][nx] == '!') {
                for(int i = 0 ; i < 2; i++) {
                    int nd = mirror[i][cur[2]], nc = visited[ny][nx][nd];
                    if(nc <= cur[3] + 1) continue;
                    nc = cur[3] + 1;
                    q.add(new int[]{ny, nx, nd, nc});
                }
            }
            if(visited[ny][nx][cur[2]] > cur[3]) {
                visited[ny][nx][cur[2]] = cur[3];
                q.add(new int[]{ny, nx, cur[2], cur[3]});
            }
        }
        System.out.println(ret);
    }
}