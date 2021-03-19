package boj_algorithm._20100;

import java.util.Scanner;

public class _20159_동작그만밑장빼기냐 {
    static int N;
    static int[] cards;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cards = new int[N];
        for(int i = 0; i < N; i++)
            cards[i] = sc.nextInt();
        System.out.println(sol());
    }

    private static int sol() {
        int[][] sum = new int[2][N/2+1];
        for (int i = 0; i < N; i++) {
            if((i + 1) % 2 == 0) sum[0][i/2+1] = sum[0][i/2] + cards[i];
            else sum[1][i/2+1] = sum[1][i/2] + cards[i];
        }
        int max = 0;
        int[] res = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int idx = i / 2 + 1;
            if(i % 2 == 0) res[i] = sum[1][idx -1] + (sum[0][N/2-1] - sum[0][idx-2]);
            else res[i] = sum[1][idx-1] + (sum[0][N/2-1] - sum[0][idx-1]) + cards[N - 1];

            max = Math.max(max, res[i]);
        }
        return max;
    }
}