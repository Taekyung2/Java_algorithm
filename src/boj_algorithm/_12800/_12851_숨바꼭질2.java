package boj_algorithm._12800;

import java.util.*;

public class _12851_숨바꼭질2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> visitq = new LinkedList<>();
        q.add(N);
        int ret = 0, cnt = 0;
        boolean[] visit = new boolean[100001];
        while(!q.isEmpty()) {
            int s = q.size();
            boolean chk = false;
            for(int c = 0; c < s; c++) {
                int cur = q.poll();
                if(visit[cur]) continue;
                visitq.add(cur);
                if(cur == K) {
                    ret++;
                    chk = true;
                }
                if(cur - 1 >= 0)
                    q.add(cur - 1);
                if(cur + 1 <= 100000)
                    q.add(cur + 1);
                if(cur != 0 && cur * 2 <= 100000)
                    q.add(cur * 2);
            }
            while(!visitq.isEmpty()) visit[visitq.poll()] = true;
            if(chk) break;
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(ret);
    }
}
