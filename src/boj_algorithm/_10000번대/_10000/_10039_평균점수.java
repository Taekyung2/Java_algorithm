package boj_algorithm._10000;

import java.util.Scanner;

public class _10039_평균점수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int sum = 0;
        while(n-- > 0) {
            int a = sc.nextInt();
            sum += Math.max(a, 40);
        }
        System.out.println(sum / 5);
    }
}