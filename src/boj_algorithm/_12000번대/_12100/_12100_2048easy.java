package boj_algorithm._12100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _12100_2048easy {
    static int N, ret = 0;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();
        sol(0);
        System.out.println(ret);
    }

   private static void sol(int cnt) {
       if(cnt == 5) {
           int max = 0;
           for(int i = 0; i < N; i++) {
               for(int j = 0; j < N; j++) {
                   max = Math.max(max, board[i][j]);
               }
           }
           ret = Math.max(ret, max);
           return;
       }
       int[][] tmp = new int[N][N];
       for(int i = 0; i < N; i++)
           tmp[i] = board[i].clone();

       for(int d = 0; d < 4; d++) {
           move(d);
           sol(cnt + 1);
           for(int i = 0; i < N; i++)
               board[i] = tmp[i].clone();
       }
   }

   private static void move(int d) {
       Queue<Integer> q = new LinkedList<>();
        switch(d) {
            case 0:
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        if(board[i][j] != 0) {
                            q.offer(board[i][j]);
                            board[i][j] = 0;
                        }
                    }
                    int idx = 0;
                    while(!q.isEmpty()) {
                        int n = q.poll();
                        if(board[i][idx] == 0) {
                            board[i][idx] = n;
                        }
                        else if(board[i][idx] == n) {
                            board[i][idx++] += n;
                        }
                        else {
                            board[i][++idx] = n;
                        }
                    }
                }
                break;
            case 1:
                for(int i = 0; i < N; i++) {
                    for(int j = N - 1; j >= 0; j--) {
                        if(board[i][j] != 0) {
                            q.offer(board[i][j]);
                            board[i][j] = 0;
                        }
                    }
                    int idx = N - 1;
                    while(!q.isEmpty()) {
                        int n = q.poll();
                        if(board[i][idx] == 0) {
                            board[i][idx] = n;
                        }
                        else if(board[i][idx] == n) {
                            board[i][idx--] += n;
                        }
                        else {
                            board[i][--idx] = n;
                        }
                    }
                }
                break;
            case 2:
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        if(board[j][i] != 0) {
                            q.offer(board[j][i]);
                            board[j][i] = 0;
                        }
                    }
                    int idx = 0;
                    while(!q.isEmpty()) {
                        int n = q.poll();
                        if(board[idx][i] == 0) {
                            board[idx][i] = n;
                        }
                        else if(board[idx][i] == n) {
                            board[idx++][i] += n;
                        }
                        else {
                            board[++idx][i] = n;
                        }
                    }
                }
                break;
            case 3:
                for(int i = 0; i < N; i++) {
                    for(int j = N - 1; j >= 0; j--) {
                        if(board[j][i] != 0) {
                            q.offer(board[j][i]);
                            board[j][i] = 0;
                        }
                    }
                    int idx = N - 1;
                    while(!q.isEmpty()) {
                        int n = q.poll();
                        if(board[idx][i] == 0) {
                            board[idx][i] = n;
                        }
                        else if(board[idx][i] == n) {
                            board[idx--][i] += n;
                        }
                        else {
                            board[--idx][i] = n;
                        }
                    }
                }
                break;
        }
   }
}