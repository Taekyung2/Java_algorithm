package boj_algorithm._2400;

import java.util.Scanner;

public class _2441_별찍기4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = N; i >= 0; i--) {
            for(int j = N - 1; j >= i; j--)
                System.out.print(" ");
            for(int j = 0; j < i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
