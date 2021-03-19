package boj_algorithm._2100;

import java.util.Scanner;

public class _2156_포도주 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        for(int i = 1; i < N + 1; i++)
            arr[i] = sc.nextInt();
        if(N == 1) {
            System.out.println(arr[1]);
            return;
        }
        int[] cache = new int[N + 1];
        cache[1] = arr[1];
        cache[2] = arr[1] + arr[2];
        for(int i = 3; i < N + 1; i++) {
            cache[i] = cache[i - 2] + arr[i];
            cache[i] = Math.max(cache[i], cache[i - 3] + arr[i - 1] + arr[i]);
            cache[i] = Math.max(cache[i - 1], cache[i]);
        }
        System.out.println(cache[N]);
    }
}