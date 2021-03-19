package boj_algorithm._2400;

import java.util.Arrays;
import java.util.Scanner;

public class _2491_수열 {
    static int N;
    static int[] arr, min_cache, max_cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        min_cache = new int[N];
        max_cache = new int[N];
        Arrays.fill(min_cache, -1);
        Arrays.fill(max_cache, -1);
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        int ret = 0;
        for(int i = 0; i < N; i++) {
            ret = Math.max(ret, dp_min(i));
            ret = Math.max(ret, dp_max(i));
        }
        System.out.println(ret);
    }

    static int dp_min(int n) {
        if(n == N - 1) return 1;
        int ret = min_cache[n];
        if(ret != -1) return ret;
        ret = 1;
        if(arr[n] <= arr[n + 1])
            ret = dp_min(n + 1) + 1;
        return min_cache[n] = ret;
    }

    static int dp_max(int n) {
        if(n == N - 1) return 1;
        int ret = max_cache[n];
        if(ret != -1) return ret;
        ret = 1;
        if(arr[n] >= arr[n + 1])
            ret = dp_max(n + 1) + 1;
        return max_cache[n] = ret;
    }
}