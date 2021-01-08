package boj_algorithm._2500;

import java.util.Scanner;

public class _2588_곱셈 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a * b;
        while(b != 0) {
            int ret = a * (b % 10);
            System.out.println(ret);
            b /= 10;
        }
        System.out.println(sum);
    }
}