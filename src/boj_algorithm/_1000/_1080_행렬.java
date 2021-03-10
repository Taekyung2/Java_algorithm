package boj_algorithm._1000;

import java.util.*;

public class _1080_행렬 {
    static int N, M, ret = 0;
    static char[][] map1, map2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map1 = new char[N][M];
        map2 = new char[N][M];
        for(int i = 0; i < N; i++) map1[i] = sc.next().toCharArray();
        for(int i = 0; i < N; i++) map2[i] = sc.next().toCharArray();
        for(int i = 1; i < N - 1; i++) {
            for(int j = 1; j < M - 1; j++) {
                if(map1[i - 1][j - 1] != map2[i - 1][j - 1]) {
                    ret++;
                    for(int r = 0; r < 3; r++)
                        for(int p = 0; p < 3; p++)
                            map1[i - 1 + r][j - 1 + p] = (map1[i - 1 + r][j - 1 + p] == '0') ? '1' : '0';
                }
            }
        }
        if(Arrays.deepEquals(map1, map2)) System.out.println(ret);
        else System.out.println(-1);
    }
}
