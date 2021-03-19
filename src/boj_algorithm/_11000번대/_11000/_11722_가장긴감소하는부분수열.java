package boj_algorithm._11000;

import java.util.Arrays;
import java.util.Scanner;

public class _11722_가장긴감소하는부분수열 {
    static int N, ret = 0;
    static int[] arr, cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        cache = new int[N];
        Arrays.fill(cache, -1);
        for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
        for(int i = 0; i < N; i++) ret = Math.max(ret, dp(i));
        System.out.println(ret);
    }

    static int dp(int idx) {
        int ret = cache[idx];
        if(ret != -1) return ret;
        ret = 1;
        for(int i = idx + 1; i < N; i++)
            if(arr[idx] > arr[i])
                ret = Math.max(ret, dp(i) + 1);
        return cache[idx] = ret;
    }
}