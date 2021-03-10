package boj_algorithm._2000;

import java.util.Scanner;

public class _2023_신기한소수 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 1; i < 10; i++)
            if(isPrime(i)) recur(i, 1);
    }

    static void recur(int n, int len) {
        if(len == N) {
            System.out.println(n);
            return;
        }
        n *= 10;
        for(int i = 0; i < 10; i++)
            if(isPrime(n + i)) recur(n + i, len + 1);
    }

    static boolean isPrime(int n) {
        if(n == 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        for(int i = 3; i <= Math.sqrt(n); i+=2)
            if(n % i == 0) return false;
        return true;
    }
}
