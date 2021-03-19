package boj_algorithm._14600;

import java.util.Scanner;

public class _14681_사분면고르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a * b > 0) {
            if(a > 0)
                System.out.println(1);
            else
                System.out.println(3);
        }
        else {
            if(a > 0)
                System.out.println(4);
            else
                System.out.println(2);
        }
    }
}