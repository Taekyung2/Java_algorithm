package boj_algorithm._7500;

import java.util.Scanner;

public class _7579_앱 {
    static int n, m;
    static int[] a, c, cache;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        a = new int[101]; c = new int[101]; cache = new int[10001];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
        for(int i = 0; i < n; i++) c[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 10000; j >= c[i]; j--)
                cache[j] = Math.max(cache[j], cache[j - c[i]] + a[i]);
        for(int i = 0; i <= 10000; i++)
            if(cache[i] >= m) {
                System.out.println(i);
                return;
            }
    }
}