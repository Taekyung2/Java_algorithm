package boj_algorithm._9600;

import java.util.Scanner;

public class _9613_gcd합 {
    static int n;
    static long ret;
    static int[] pick, num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            num = new int[n];
            pick = new int[2];
            ret = 0;
            for(int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }
            comb(0, 0);
            System.out.println(ret);
        }
    }

    private static void comb(int cnt, int cur) {
        if(cnt == 2) {
            ret += gcd(pick[0], pick[1]);
            return;
        }

        for(int i = cur; i < n; i++) {
           pick[cnt] = num[i];
           comb(cnt + 1, i + 1);
        }
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}