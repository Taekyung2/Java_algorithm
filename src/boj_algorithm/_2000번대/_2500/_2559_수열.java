package boj_algorithm._2500;

import java.util.Scanner;

public class _2559_수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N + 1];
        int ret = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++)
            arr[i] = arr[i - 1] + sc.nextInt();
        for(int i = K; i <= N; i++)
            ret = Math.max(ret, arr[i] - arr[i - K]);
        System.out.println(ret);
    }
}
