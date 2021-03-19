package boj_algorithm._1700;

import java.io.*;
import java.util.StringTokenizer;

public class _1717_집합의표현 {
    static int N, M;
    static int[] parent;
    static int[] rank;

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return;
        if(rank[a] >= rank[b]) {
            parent[b] = a;
            if(rank[a] == rank[b]) rank[a]++;
        }
        else parent[a] = b;
    }

    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        rank = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(op == 0) union(a, b);
            else {
                if(find(a) == find(b)) sb.append("YES");
                else sb.append("NO");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
