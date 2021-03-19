package boj_algorithm._12000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _12094_2048hard {
    static int N, ret;
    static int[][] board;
    static int[] cut = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();
        ret = findMax();
        sol(0);
        System.out.println(ret);
    }

    private static int findMax() {
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        return max;
    }

    private static void sol(int cnt) {
        int max = findMax();
        if(max <= cut[cnt]) return;
        if(cnt == 10) {
            if(ret < max) {
                ret = max;
                int idx = cnt;
                while (max > 0 && idx >= 0) {
                    cut[idx--] = max;
                    max /= 2;
                }
            }
            return;
        }
        int[][] tmp = new int[N][N];
        for(int i = 0; i < N; i++)
            tmp[i] = board[i].clone();

        for(int d = 0; d < 4; d++) {
            move(d);
            boolean same = true;
            loop:
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(board[i][j] != tmp[i][j]) {
                        same = false;
                        break loop;
                    }
                }
            }
            if(same) continue;
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