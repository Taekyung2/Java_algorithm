package boj_algorithm._9100;

import java.util.Scanner;

public class _9184_신나는함수실행 {
    static int[][][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cache = new int[51][51][51];
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a == -1 && b == -1 && c == -1) break;
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }
    }

    public static int w(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if(cache[a][b][c] != 0) return cache[a][b][c];
        if(a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        if(a < b && b < c) return cache[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        return cache[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}