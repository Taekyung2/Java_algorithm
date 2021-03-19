package boj_algorithm._2100;

import java.util.Scanner;

public class _2133_타일채우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cache = new int[N + 1];
        if(N == 1) {
            System.out.println(0);
            return;
        }
        cache[0] = 1;
        cache[1] = 0;
        cache[2] = 3;
        for(int i = 3; i <= N; i++) {
            cache[i] += 3 * cache[i - 2];
            for(int j = i - 4; j >= 0; j-=2)
                cache[i] += 2 * cache[j];
        }
        System.out.println(cache[N]);
    }
}
