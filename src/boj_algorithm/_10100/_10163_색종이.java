package boj_algorithm._10100;

import java.util.Scanner;

public class _10163_색종이 {
    static int[][] map = new int[102][102];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1; i <= N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();
            for(int j = b; j < b + h; j++)
                for(int k = a; k < a + w; k++)
                    map[j][k] = i;
        }
        int[] cnt = new int[N + 1];
        for(int[] a : map)
            for(int b : a)
                cnt[b]++;
        for(int i = 1; i <= N; i++)
            System.out.println(cnt[i]);
    }
}