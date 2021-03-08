package boj_algorithm._6600;

import java.util.Scanner;

public class _6603_로또 {
    static int K;
    static int[] arr, pick;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pick = new int[6];
        while(true) {
            K = sc.nextInt();
            if(K == 0) break;
            arr = new int[K];
            for(int i = 0; i < K; i++)
                arr[i] = sc.nextInt();
            comb(0, 0);
            System.out.println();
        }
    }

    static void comb(int idx, int cnt) {
        if(cnt == 6) {
            for(int n : pick)
                System.out.print(n + " ");
            System.out.println();
            return;
        }
        if(idx == K) return;
        pick[cnt] = arr[idx];
        comb(idx + 1, cnt + 1);
        comb(idx + 1, cnt);
    }
}
