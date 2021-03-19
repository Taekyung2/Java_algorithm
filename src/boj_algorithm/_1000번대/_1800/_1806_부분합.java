package boj_algorithm._1800;

import java.util.Scanner;

public class _1806_부분합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++)
            a[i] = sc.nextInt();
        int l = 0, r = 0, sum = 0, len = 0, ret = Integer.MAX_VALUE;
        while(true) {
            if(sum >= S) {
                ret = Math.min(ret, len);
                sum -= a[l];
                l++;
                len--;
            } else {
                if(r == N) break;
                sum += a[r];
                r++;
                len++;
            }
        }
        System.out.println(ret == Integer.MAX_VALUE ? 0 : ret);
    }
}