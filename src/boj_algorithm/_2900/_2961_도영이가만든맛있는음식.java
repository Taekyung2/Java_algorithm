package boj_algorithm._2900;

import java.util.Scanner;

public class _2961_도영이가만든맛있는음식 {
    static class G {
        int s, ss;
        G(int s, int ss) {
            this.s = s;
            this.ss= ss;
        }
    }
    static int N;
    static long ret = Long.MAX_VALUE;
    static G[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new G[N];
        for(int i = 0; i < N; i++) arr[i] = new G(sc.nextInt(), sc.nextInt());
        for(int i = 1; i < (1 << N); i++) {
            long sum_s = 1, sum_ss = 0;
            for(int j = 0; j < N; j++) {
                if((i & (1 << j)) != 0) {
                    sum_s *= arr[j].s;
                    sum_ss += arr[j].ss;
                }
            }
            ret =  Math.min(ret, Math.abs(sum_s - sum_ss));
        }
        System.out.println(ret);
    }
}