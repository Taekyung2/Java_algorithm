package boj_algorithm._20000번대._20000;

import java.util.ArrayList;
import java.util.Scanner;

public class _20056_마법사상어와파이어볼 {
    static class Fire {
        int y, x, m, s, d;
        Fire(int y, int x, int m, int s, int d) {
            this.y = y;
            this.x = x;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    static int N, M, K;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<Fire>[][] map, tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new ArrayList[N][N];
        tmp = new ArrayList[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
                tmp[i][j] = new ArrayList<>();
            }
        for(int i = 0; i < M; i++) {
            Fire f = new Fire(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt(), sc.nextInt(), sc.nextInt());
            map[f.y][f.x].add(f);
        }
        while(K-- > 0)
            simulation();
        System.out.println(count());
    }

    static Fire move(Fire f) {
        for(int i=0;i < f.s;i++){
            f.y += dy[f.d];
            if(f.y == N)
                f.y = 0;
            else if(f.y == -1)
                f.y = N - 1;

            f.x += dx[f.d];
            if(f.x == N)
                f.x = 0;
            else if(f.x == -1)
                f.x = N - 1;
        }
        return f;
    }

    static void simulation() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++) {
                if(map[i][j].isEmpty()) continue;
                for(Fire f : map[i][j]) {
                    Fire next = move(f);
                    tmp[next.y][next.x].add(next);
                }
                map[i][j].clear();
            }

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++) {
                if(tmp[i][j].isEmpty()) continue;
                for(Fire f : tmp[i][j])
                    map[i][j].add(f);
                tmp[i][j].clear();
            }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j].size() < 2) continue;
                int m = 0, s = 0, cnt = map[i][j].size();
                boolean even_chk = true, odd_chk = true;
                for(Fire f : map[i][j]) {
                    m += f.m;
                    s += f.s;
                    if(f.d % 2 == 0) odd_chk = false;
                    else even_chk = false;
                }
                map[i][j].clear();
                m /= 5;
                s /= cnt;
                if(m == 0) continue;
                if(odd_chk || even_chk) {
                    for(int d = 0; d < 8; d+=2) {
                        map[i][j].add(new Fire(i, j, m, s, d));
                    }
                } else {
                    for(int d = 1; d < 8; d+=2) {
                        map[i][j].add(new Fire(i, j, m, s, d));
                    }
                }
            }
        }
    }

    static int count() {
        int ret = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j].isEmpty()) continue;
                for(Fire f : map[i][j])
                    ret += f.m;
            }
        }
        return ret;
    }
}
