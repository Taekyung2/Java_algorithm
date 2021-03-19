package boj_algorithm._10900;

import java.util.Arrays;
import java.util.Scanner;

public class _10971_외판원순회2 {
    static int N, INF = 987654321;
    static int[][] map;
    static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        cache = new int[N][(1 << N)];
        for(int i = 0; i < N; i++) {
            Arrays.fill(cache[i], -1);
        }
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();
        System.out.println(tcp(0, 1));
    }

    public static int tcp(int cur, int visited) {
        if(visited == (1 << N) - 1) {
            if(map[cur][0] != 0)
                return map[cur][0];
            else
                return INF;
        }
        int ret = cache[cur][visited];
        if(ret != -1) return ret;
        ret = INF;
        for(int i = 0; i < N; i++) {
            if((visited & (1 << i)) != 0 || map[cur][i] == 0) continue;
            ret = Math.min(ret, map[cur][i] + tcp(i, visited | (1 << i)));
        }
        return cache[cur][visited] = ret;
    }
}