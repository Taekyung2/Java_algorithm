package boj_algorithm._2200;

import java.util.*;

public class _2217_로프 {
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++)
             arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int ret = arr[0] * N;
        for(int i = 1; i < N; i++)
            ret = Math.max(ret, arr[i] * (N - i));
        System.out.println(ret);
    }
}