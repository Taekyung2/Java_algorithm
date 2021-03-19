package boj_algorithm._1200;

import java.util.Scanner;

public class _1292_쉽게푸는문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        int[] arr = new int[1001];
        int idx = 0;
        loop:
        for(int i = 1; i <= 50; i++) {
            for(int j = 0; j < i; j++) {
                arr[idx++] = i;
                if(idx > 1000) break loop;
            }
        }
        int sum = 0;
        for(int i = a; i <= b; i++)
            sum += arr[i];
        System.out.println(sum);
    }
}
