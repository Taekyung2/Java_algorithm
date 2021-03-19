package boj_algorithm._4100;

import java.io.*;
import java.util.*;

public class _4195_친구네트워크 {
    final static int MAX = 200001;
    static int[] parent, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> m = new HashMap<>();
            init();
            int idx = 0;
            for(int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                m.putIfAbsent(s[0], idx++);
                m.putIfAbsent(s[1], idx++);
                System.out.println(union(m.get(s[0]), m.get(s[1])));
            }
        }
    }

    static void init() {
        parent = new int[MAX];
        cnt = new int[MAX];
        for(int i = 0; i < MAX; i++) {
            parent[i] = i;
            cnt[i] = 1;
        }
    }

    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static int union(int a, int b) {
        a = find(a); b = find(b);
        if(a == b) return cnt[a];
        if(cnt[a] <= cnt[b]) {
            parent[a] = b;
            cnt[b] += cnt[a];
            return cnt[b];
        } else {
            parent[b] = a;
            cnt[a] += cnt[b];
            return cnt[a];
        }
    }
}
