package boj_algorithm._13900;

import java.util.*;

public class _13913_숨바꼭질4 {
    final static int MAX = 100001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] visit = new int[MAX];
        Arrays.fill(visit, MAX);
        int[] path = new int[MAX];
        Queue<Integer> q = new LinkedList<>();
        visit[N] = 0;
        path[N] = -1;
        q.add(N);
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == K) break;
            int[] next = {cur - 1, cur + 1, 2 * cur};
            for(int n : next) {
                if(n < 0 || n >= MAX || visit[n] < visit[cur] + 1) continue;
                q.add(n);
                visit[n] = visit[cur] + 1;
                path[n] = cur;
            }
        }
        System.out.println(visit[K]);
        ArrayList<Integer> ret = new ArrayList<>();
        while(K != -1) {
            ret.add(K);
            K = path[K];
        }
        Collections.reverse(ret);
        ret.forEach(x -> System.out.print(x + " "));
    }
}
