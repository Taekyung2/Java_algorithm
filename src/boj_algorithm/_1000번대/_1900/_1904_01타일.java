package boj_algorithm._1900;

import java.util.Scanner;

public class _1904_01타일 {
    static int[] cache = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cache[1] = 1;
        cache[2] = 2;
        for(int i = 3; i <= N; i++) {
            cache[i] = (cache[i - 1] + cache[i - 2]) % 15746;
        }
        System.out.println(cache[N] % 15746);
    }
}