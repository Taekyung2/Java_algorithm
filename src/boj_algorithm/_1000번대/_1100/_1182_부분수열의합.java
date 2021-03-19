package boj_algorithm._1100;

import java.util.Scanner;

public class _1182_부분수열의합 {
    static int N, S, ret = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        sol(1);
        System.out.println(ret);
    }

    public static void sol(int num) {
        if(num >= (1 << N)) return;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            if((num & (1 << i)) != 0) {
                sum += arr[i];
            }
        }
        if(sum == S) ret++;
        sol(num + 1);
    }
}
