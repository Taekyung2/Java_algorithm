package boj_algorithm._17000번대._17400;

import java.util.*;

public class _17471_게리맨더링 {
    static int N, ret = Integer.MAX_VALUE;
    static int[] people;
    static boolean[] chk;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adj = new ArrayList[N];
        people = new int[N];
        chk = new boolean[N];
        for(int i = 0; i < N; i++) {
            people[i] = sc.nextInt();
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++) {
           int s = sc.nextInt();
           for(int j = 0; j < s; j++)
                adj[i].add(sc.nextInt() - 1);
        }
        for(int i = 1; i <= N / 2; i++) {
            Arrays.fill(chk, false);
            comb(i, 0, 0);
        }
        System.out.println((ret == Integer.MAX_VALUE) ? -1 : ret);
    }

    static void comb(int num, int idx, int cnt) {
        if(cnt == num) {
            if(isConnect())
                ret = Math.min(ret, count());
            return;
        }
        if(idx >= N) return;
        chk[idx] = true;
        comb(num, idx + 1, cnt + 1);
        chk[idx] = false;
        comb(num, idx + 1, cnt);
    }

    static boolean isConnect() {
        ArrayList<Integer> pick1 = new ArrayList<>();
        ArrayList<Integer> pick2 = new ArrayList<>();
        for(int i = 0; i < N; i++)
            if(chk[i]) pick1.add(i);
            else pick2.add(i);
        return bfs(pick1.get(0), pick1, true) && bfs(pick2.get(0), pick2, false);
    }

    static boolean bfs(int n, ArrayList<Integer> list, boolean check) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(n);
        visited[n] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : adj[cur]) {
                if(visited[next] || chk[next] != check) continue;
                visited[next] = true;
                q.add(next);
            }
        }
        for(int num : list)
            if(!visited[num]) return false;
        return true;
    }

    static int count() {
        int sum = 0;
        for(int i = 0; i < N; i++)
            if(chk[i]) sum += people[i];
            else sum -= people[i];
        return Math.abs(sum);
    }
}
