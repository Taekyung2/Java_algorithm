package boj_algorithm._11000;

import java.util.Arrays;
import java.util.Scanner;

public class _11054_가장긴바이토닉부분수열 {
    static int N, ret = 0;
    static int[] arr;
    static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        cache = new int[N][2];
        for(int i = 0; i < N; i++)
            Arrays.fill(cache[i], -1);
        for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
        for(int i = 0; i < N; i++)
            ret = Math.max(ret, dp(i, 0));
        System.out.println(ret);
    }

    static int dp(int idx, int chk) {
        int ret = cache[idx][chk];
        if(ret != -1) return ret;
        ret = 1;
        for(int i = idx + 1; i < N; i++) {
            if (chk == 0 && arr[idx] < arr[i]) ret = Math.max(ret, dp(i, 0) + 1);
            else if (arr[idx] > arr[i]) ret = Math.max(ret, dp(i, 1) + 1);
        }
        return cache[idx][chk] = ret;
    }
}