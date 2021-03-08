package boj_algorithm._2500;

import java.util.*;

public class _2565_전깃줄 {
    static class Line {
        int from, to;
        Line(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    static int N;
    static Line[] arr;
    static int[] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new Line[N + 1];
        cache = new int[N + 1];
        Arrays.fill(cache, -1);
        arr[0] = new Line(0, Integer.MIN_VALUE);
        for(int i = 1; i <= N; i++)
            arr[i] = new Line(sc.nextInt(), sc.nextInt());
        Arrays.sort(arr, (l1, l2)-> {
            if(l1.from == l2.from) return l1.to - l2.to;
            return l1.from - l2.from;
        });
        System.out.println(N - dp(0) + 1);
    }

    static int dp(int cur) {
        int ret = cache[cur];
        if(ret != -1) return ret;
        ret = 1;
        for(int i = cur + 1; i <= N; i++)
            if(arr[cur].to < arr[i].to)
                ret = Math.max(ret, dp(i) + 1);
        return cache[cur] = ret;
    }
}
