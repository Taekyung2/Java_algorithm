package boj_algorithm._13400;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _13460_구슬탈출2 {

    static class ball {
        int ry, rx, by, bx, cnt;

        public ball(int ry, int rx, int by, int bx, int cnt) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static boolean[][][][] chk = new boolean[10][10][10][10];
    static ball cur = new ball(0, 0, 0, 0, 0);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String tmp = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == 'B') {
                    cur.by = i;
                    cur.bx = j;
                }
                if(map[i][j] == 'R') {
                    cur.ry = i;
                    cur.rx = j;
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
       Queue<ball> q = new LinkedList<>();
       q.add(cur);
       while(!q.isEmpty()) {
           ball cur = q.poll();
           for(int d = 0; d < 4; d++) {
               int nby = cur.by;
               int nbx = cur.bx;
               int nry = cur.ry;
               int nrx = cur.rx;
               int cb = 0, cr = 0;
               while(map[nby + dy[d]][nbx + dx[d]] != '#' && map[nby][nbx] != 'O') {
                   nby += dy[d];
                   nbx += dx[d];
                   cb++;
               }
               while(map[nry + dy[d]][nrx + dx[d]] != '#' && map[nry][nrx] != 'O') {
                   nry += dy[d];
                   nrx += dx[d];
                   cr++;
               }
               if(nry == nby && nrx == nbx) {
                   if(map[nry][nrx] == 'O') continue;
                   if(cr < cb) {
                       nby -= dy[d];
                       nbx -= dx[d];
                   } else {
                       nry -= dy[d];
                       nrx -= dx[d];
                   }
               }
               if(map[nry][nrx] == 'O') return cur.cnt + 1;
               if(map[nby][nbx] == 'O') continue;
               if(chk[nby][nbx][nry][nrx]) continue;
               if(cur.cnt < 9) {
                   chk[nby][nbx][nry][nrx] = true;
                   q.add(new ball(nry, nrx, nby, nbx, cur.cnt + 1));
               }
           }
       }
       return -1;
    }
}