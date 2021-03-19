package boj_algorithm._13400;

import java.util.Scanner;

public class _13458_시험감독 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        long ret = N;
        for(int i = 0; i < N; i++) {
            if(A[i] - B < 0) continue;
            ret += (A[i] - B) / C;
            if((A[i] - B) % C != 0)
                ret++;
        }
        System.out.println(ret);
    }
}