package boj_algorithm._14000;

import java.util.*;

public class _14002_가장긴증가하는부분수열4 {
    static int N;
    static int[] cache, arr, choice;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1]; cache = new int[N + 1]; choice = new int[N + 1];
        for(int i = 1; i <= N; i++) arr[i] = sc.nextInt();
        arr[0] = Integer.MIN_VALUE;
        Arrays.fill(cache, -1);
        System.out.println(dp(0) - 1);
        reconstruct(0);
        list.forEach(x -> System.out.print(x + " "));
    }

    static int dp(int cur) {
        int ret = cache[cur];
        if(ret != -1) return ret;
        ret = 1;
        int next = -1;
        for(int i = cur + 1; i <= N; i++) {
            if(arr[i] > arr[cur]) {
                int cand = dp(i) + 1;
                if(cand > ret) {
                    ret = cand;
                    next = i;
                }
            }
        }
        choice[cur] = next;
        return cache[cur] = ret;
    }

    static void reconstruct(int s) {
        if(s != 0) list.add(arr[s]);
        int next = choice[s];
        if(next != -1) reconstruct(next);
    }
}