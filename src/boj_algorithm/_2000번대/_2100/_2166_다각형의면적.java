package boj_algorithm._2100;

import java.util.Scanner;

public class _2166_다각형의면적 {
    static long[] x = new long[10001];
    static long[] y = new long[10001];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        double ret = 0;
        int j = n - 1;
        for(int i = 0; i < n; i++) {
            ret += (x[j] + x[i]) * (y[j] - y[i]);
            j = i;
        }
        System.out.printf("%.1f",Math.abs(ret) / 2);
    }
}