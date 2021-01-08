package boj_algorithm._11600;

import java.util.Scanner;

public class _11653_소인수분해 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = 2;
        int tmp = N;
        if(N == 1) return;
        while(true) {
            if(a > tmp) break;
            if(N % a == 0) {
                System.out.println(a);
                N /= a;
            }
            else {
                a++;
            }
        }
    }
}
