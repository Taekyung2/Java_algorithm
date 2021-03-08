package boj_algorithm._2500;

import java.util.Scanner;

public class _2563_색종이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[][] board = new boolean[101][101];
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for(int j = x; j < x + 10; j++)
                for(int r = y; r < y + 10; r++)
                    if(!board[r][j]) {
                        board[r][j] = true;
                        cnt++;
                    }
        }
        System.out.println(cnt);
    }
}
