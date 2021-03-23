package boj_algorithm._2300;

import java.util.Scanner;

public class _2304_창고다각형 {
    static int[][] d = new int[1001][3];
    static int ret, max, n, MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            d[a][0] = b;
            MAX = Math.max(MAX, a);
        }
        for(int i = 0; i <= MAX; i++) {
            max = Math.max(d[i][0], max);
            d[i][1]=  max;
        }
        max = 0;
        for(int i = MAX; i >= 0; i--) {
            max = Math.max(max, d[i][0]);
            d[i][2] = max;
        }
        for(int i = 0; i <= MAX; i++)
            ret += Math.min(d[i][1], d[i][2]);
        System.out.println(ret);
    }
}