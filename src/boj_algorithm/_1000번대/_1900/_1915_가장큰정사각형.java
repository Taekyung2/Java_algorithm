package boj_algorithm._1900;

import java.util.Scanner;

public class _1915_가장큰정사각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < M; j++)
                map[i][j] = (int)s.charAt(j) - '0';
        }
        for(int i = 1; i < N; i++)
            for(int j = 1; j < M; j++)
                if(map[i][j] != 0)
                    map[i][j] += Math.min(map[i - 1][j], Math.min(map[i][j - 1], map[i - 1][j - 1]));
        int ret = 0;
        for(int[] a : map)
            for(int n : a)
                ret = Math.max(ret, n);
        System.out.println(ret * ret);
    }
}
