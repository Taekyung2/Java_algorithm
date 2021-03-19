package boj_algorithm._1000;

import java.util.*;

public class _1068_트리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[N];
        for(int i = 0; i < N; i++)
            adj[i] = new ArrayList<>();
        int root = -1;
        for(int i = 0; i < N; i++) {
            int node = sc.nextInt();
            if(node == -1) root = i;
            else {
                adj[i].add(node);
                adj[node].add(i);
            }
        }
        int remove = sc.nextInt();
        if(remove == root) {
            System.out.println(0);
            return;
        }
        int ret = 0;
        boolean[] discovered = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        discovered[root] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            boolean chk = false;
            for(int next : adj[cur]) {
                if(discovered[next] || next == remove) continue;
                chk = true;
                discovered[next] = true;
                q.add(next);
            }
            if(!chk) ret++;
        }
        System.out.println(ret);
    }
}
