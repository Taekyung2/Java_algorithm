package boj_algorithm._2500;

import java.util.*;

public class _2564_경비원 {
    static int x, y;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        int k = sc.nextInt();
        int[][] map = new int[y + 1][x + 1];
        for(int i = 0; i <= x; i++) {
            map[0][i] = 1;
            map[y][i] = 1;
        }
        for(int i = 0; i <= y; i++) {
            map[i][0] = 1;
            map[i][x] = 1;
        }
        for(int i = 0; i < k; i++) {
            int dir = sc.nextInt(), dist = sc.nextInt();
            int[] pair = change(dir, dist);
            map[pair[0]][pair[1]] = 2;
        }
        int[] s = change(sc.nextInt(), sc.nextInt());
        int ret = 0, cnt = 0, dist = 1;
        map[s[0]][s[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int c = 0; c < size; c++) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int ny = cur[0] + dy[d], nx = cur[1] + dx[d];
                    if (ny < 0 || nx < 0 || ny > y || nx > x || map[ny][nx] == 0) continue;
                    q.add(new int[]{ny, nx});
                    if (map[ny][nx] == 2) {
                        ret += dist;
                        cnt++;
                        if(cnt == k) {
                            System.out.println(ret);
                            return;
                        }
                    }
                }
                map[cur[0]][cur[1]] = 0;
            }
            dist++;
        }
    }

    static int[] change(int dir, int dist) {
        int[] ret = {-1, -1};
        if(dir == 1) {
            ret[0] = 0; ret[1] = dist;
        } else if(dir == 2) {
            ret[0] = y; ret[1] = dist;
        } else if(dir == 3) {
            ret[0] = dist; ret[1] = 0;
        } else if(dir == 4) {
            ret[0] = dist; ret[1] = x;
        }
        return ret;
    }
}
