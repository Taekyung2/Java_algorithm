package boj_algorithm._1600;

import java.util.Scanner;

public class _1699_제곱수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cache = new int[100001];
        for(int i = 1; i <= N; i++)
             cache[i] = i;
        for(int i = 4; i <= N; i++)
            for(int j = 2; j * j <= i; j++)
                cache[i] = Math.min(cache[i], cache[i - j * j] + 1);
        System.out.println(cache[N]);
    }
}
