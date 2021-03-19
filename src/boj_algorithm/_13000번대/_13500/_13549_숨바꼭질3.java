package boj_algorithm._13500;

import java.util.*;

public class _13549_숨바꼭질3 {
    final static int MAX = 100000;
    static int N, K;
    static int[] d = new int[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        Arrays.fill(d, -1);
        d[N] = 0;
        Deque<Integer> q = new LinkedList<>();
        q.add(N);
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == K) {
                System.out.println(d[cur]);
                return;
            }
            int[] next = new int[]{2 * cur, cur - 1, cur + 1};
            for(int nx : next) {
                if(nx < 0 || nx > MAX || d[nx] >= 0) continue;
                if(nx == 2 * cur) {
                    q.addFirst(nx);
                    d[nx] = d[cur];
                } else {
                    q.addLast(nx);
                    d[nx] = d[cur] + 1;
                }
            }
        }
    }
}