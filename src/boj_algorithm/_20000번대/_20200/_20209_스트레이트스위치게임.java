package boj_algorithm._20000번대._20200;

import java.util.*;

public class _20209_스트레이트스위치게임 {
    static int N, K, INF = (int)1e9;
    static List<Integer>[] adj;
    static int[] cube;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); K = sc.nextInt();
        cube = new int[N + 1];
        adj = new List[K + 1];
        for(int i = 1; i <= K; i++)
            adj[i] = new ArrayList<>();
        for(int i = 1; i <= N; i++)
            cube[i] = sc.nextInt();
        for(int i = 1; i <= K; i++) {
            int n = sc.nextInt();
            for(int j = 0; j < n; j++)
                adj[i].add(sc.nextInt());
        }
        int ret = solve(1);
        System.out.println(ret == INF ? -1 : ret);
    }

    static boolean isSame() {
        for(int i = 1; i < N; i++)
            if(cube[i] != cube[i + 1]) return false;
        return true;
    }

    static void push(int cur) {
        for(int n : adj[cur]) {
            cube[n] += cur;
            cube[n] %= 5;
        }
    }

    static int solve(int cur) {
        if(cur == K + 1) return isSame() ? 0 : INF;
        int ret = INF;
        for(int c = 0; c < 5; c++) {
            ret = Math.min(ret, c + solve(cur + 1));
            push(cur);
        }
        return ret;
    }
}