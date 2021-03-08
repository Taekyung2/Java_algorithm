package boj_algorithm._2000;

import java.util.Scanner;

public class _2004_조합0의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = n - m;
        int f = 0, t = 0;
        for(long i = 5; i <= n; i*=5) f += n / i - r / i - m / i;
        for(long i = 2; i <= n; i*=2) t += n / i - r / i - m / i;
        System.out.println(Math.min(t, f));
    }
}
