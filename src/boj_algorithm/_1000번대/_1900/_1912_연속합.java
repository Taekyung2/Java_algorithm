package boj_algorithm._1900;

import java.util.Scanner;

public class _1912_연속합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] sum = new int[n];
        int ret = sum[0] = arr[0];
        for(int i = 1; i < n; i++) {
            sum[i] = Math.max(arr[i], sum[i - 1] + arr[i]);
            ret = Math.max(ret, sum[i]);
        }
        System.out.println(ret);
    }
}
