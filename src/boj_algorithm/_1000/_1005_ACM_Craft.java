package boj_algorithm._1000;

import java.io.*;
import java.util.*;

public class _1005_ACM_Craft {
    static int stoi(String s) { return Integer.parseInt(s); };
    static int N, K, ret, e;
    static int[] time, visit;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = stoi(br.readLine());
        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken()); K = stoi(st.nextToken());
            ret = 0;
            time = new int[N]; visit = new int[N];
            boolean[] root = new boolean[N];
            adj = new ArrayList[N];
            for(int i = 0; i < N; i++)
                adj[i] = new ArrayList<>(N);
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                time[i] = stoi(st.nextToken());
                visit[i] = time[i];
            }
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = stoi(st.nextToken()) - 1, to = stoi(st.nextToken()) - 1;
                adj[from].add(to);
                root[to] = true;
            }
            e = stoi(br.readLine()) - 1;
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < N; i++)
                if(!root[i]) q.add(i);
            while(!q.isEmpty()) {
                int cur = q.poll();
                for(int next : adj[cur]) {
                    if(visit[next] >= visit[cur] + time[next]) continue;
                    visit[next] = visit[cur] + time[next];
                    q.add(next);
                }
            }
            System.out.println(visit[e]);
        }
    }
}
