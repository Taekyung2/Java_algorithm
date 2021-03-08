package boj_algorithm._16900;

import java.util.Scanner;

public class _16926_배열돌리기1 {
    static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        arr = new int[n][m];
        int k = Math.min(n, m) / 2;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();
        rotate(k);
        for(int[] a : arr) {
            for (int n : a)
                System.out.print(n + " ");
            System.out.println();
        }
    }

    public static void rotate(int k) {
        while(r-- > 0) {
            for(int t = 0; t < k; t++) {
                int tmp = arr[t][t];
                for(int i = t + 1; i < m - t; i++)
                    arr[t][i - 1] = arr[t][i];
                for(int i = t + 1; i < n - t; i++)
                    arr[i - 1][m - t - 1] = arr[i][m - t - 1];
                for(int i = m - t - 2; i >= t; i--)
                    arr[n - t - 1][i + 1] = arr[n - t - 1][i];
                for(int i = n - t - 2; i > t; i--)
                    arr[i + 1][t] = arr[i][t];
                arr[t + 1][t] = tmp;
            }
        }
    }
}