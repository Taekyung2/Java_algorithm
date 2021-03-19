package boj_algorithm._18400;

import java.util.*;

public class _18405_경쟁적전염 {
    static class V {
        int idx, t, y, x;
        V(int idx, int t, int y, int x) {
            this.idx = idx;
            this.t = t;
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
        int[][] map = new int[N][N];
        List<V> li = new ArrayList<>();
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0) li.add(new V(map[i][j], 0, i, j));
            }
        li.sort(Comparator.comparingInt(v -> v.idx));
        Queue<V> q = new LinkedList<>(li);
        int s = sc.nextInt(), x = sc.nextInt() - 1, y = sc.nextInt() - 1, cnt = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            if(cnt == s) break;
            for(int c = 0; c < size; c++) {
                V cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int ny = cur.y + dy[d], nx = cur.x + dx[d];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] != 0) continue;
                    q.add(new V(cur.idx, cur.t + 1, ny, nx));
                    map[ny][nx] = cur.idx;
                }
            }
            cnt++;
        }
        System.out.println(map[x][y]);
    }
}