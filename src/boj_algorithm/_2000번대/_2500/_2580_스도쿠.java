package boj_algorithm._2500;

import java.util.Scanner;

public class _2580_스도쿠 {
    static int[][] map;
    static boolean[][] col, row, square;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[9][9];
        col = new boolean[9][10];
        row = new boolean[9][10];
        square = new boolean[9][10];
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0)
                    col[j][map[i][j]] = row[i][map[i][j]] = square[getIdx(i, j)][map[i][j]] = true;
            }
        }
        backtracking(0);
    }

    static void backtracking(int cnt) {
        if(cnt == 81) {
            for(int[] a : map) {
                for(int b : a)
                    System.out.print(b + " ");
                System.out.println();
            }
            System.exit(0);
        }
        int y = cnt / 9;
        int x = cnt % 9;
        if(map[y][x] != 0) backtracking(cnt + 1);
        else {
            for(int k = 1; k <= 9; k++) {
                if(col[x][k] || row[y][k] || square[getIdx(y, x)][k]) continue;
                map[y][x] = k;
                col[x][k] = row[y][k] = square[getIdx(y, x)][k] = true;
                backtracking(cnt + 1);
                col[x][k] = row[y][k] = square[getIdx(y, x)][k] = false;
            }
        }
    }

    static int getIdx(int y, int x) {
        return (y / 3) * 3 + x / 3;
    }
}
