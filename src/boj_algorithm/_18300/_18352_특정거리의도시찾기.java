package boj_algorithm._18300;

import java.io.*;
import java.util.*;

public class _18352_특정거리의도시찾기 {

    static int N, M, K, X;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        X = stoi(st.nextToken());
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            adj[stoi(st.nextToken())].add(stoi(st.nextToken()));
        }
        ArrayList<Integer> ret = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        visited[X] = true;
        q.add(X);
        while(!q.isEmpty()) {
            int c = q.size();
            for(int s = 0; s < c; s++) {
                int cur = q.poll();
                if(K == 0) {
                    ret.add(cur);
                    continue;
                }
                for(int next : adj[cur]) {
                    if(visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                }
            }
            K--;
        }
        Collections.sort(ret);
        if(ret.isEmpty()) System.out.println(-1);
        else {
            for(int n : ret)
                System.out.println(n);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
