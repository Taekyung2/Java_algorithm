package boj_algorithm._16900;

import java.util.*;

public class _16953_atob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        Queue<Long> q = new LinkedList<>();
        q.add(a);
        int cnt = 0;
        while(!q.isEmpty()) {
            int s = q.size();
            for(int iter = 0; iter < s; iter++) {
                long cur = q.poll();
                if(cur == b) {
                    System.out.println(cnt + 1);
                    return;
                }
                if(cur * 2 <= b)
                    q.add(cur * 2);
                if(cur * 10 + 1 <= b)
                    q.add(cur * 10 + 1);
            }
            cnt++;
        }
        System.out.println(-1);
    }
}
