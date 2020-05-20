package boj_algorithm._16200;

import java.util.Scanner;

public class _16236_아기상어 {
    static class Point {
        int y, x, size;

        public Point(int y, int x, int size) {
            this.y = y;
            this.x = x;
            this.size = size;
        }
    }
    static int N, baby_size;
    static int[][] map;
    static Point baby;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9) {
                    baby = new Point(i, j, 2);
                    map[i][j] = 0;
                }
            }
        }

        
    }    
}