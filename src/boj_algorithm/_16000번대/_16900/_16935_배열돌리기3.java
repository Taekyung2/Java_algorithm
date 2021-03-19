package boj_algorithm._16900;

import java.util.Scanner;

public class _16935_배열돌리기3 {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        arr = new int[N][M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                arr[i][j] = sc.nextInt();
        for(int i = 0; i < R; i++) {
            int op = sc.nextInt();
            controller(op);
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void controller(int op) {
        switch (op) {
            case 1 -> sol1();
            case 2 -> sol2();
            case 3 -> sol3();
            case 4 -> sol4();
            case 5 -> sol5();
            case 6 -> sol6();
        }
    }

    // 상하 반전
    public static void sol1() {
        for(int i = 0; i < N / 2; i++) {
            for(int j = 0; j < M; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[N - 1 - i][j];
                arr[N - 1 - i][j] = tmp;
            }
        }
    }

    // 좌우 반전
    public static void sol2() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M / 2; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[i][M - 1 - j];
                arr[i][M - 1- j] = tmp;
            }
        }
    }

    // 오른쪽 90
    public static void sol3() {
        int[][] tmp = copy();
        arr = new int[M][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[j][N - 1 - i] = tmp[i][j];
            }
        }
        swap();
    }

    // 왼쪽 90
    public static void sol4() {
        int[][] tmp = copy();
        arr = new int[M][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[M - 1 - j][i] = tmp[i][j];
            }
        }
        swap();
    }

    public static void sol5() {
        int[][] tmp = copy();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                switch(chk(i, j)) {
                    case 1 -> arr[i][j + M / 2] = tmp[i][j];
                    case 2 -> arr[i + N / 2][j] = tmp[i][j];
                    case 3 -> arr[i][j - M / 2] = tmp[i][j];
                    case 4 -> arr[i - N / 2][j] = tmp[i][j];
                }
            }
        }
    }

    public static void sol6() {
        int[][] tmp = copy();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                switch(chk(i, j)) {
                    case 1 -> arr[i + N / 2][j] = tmp[i][j];
                    case 2 -> arr[i][j - M / 2] = tmp[i][j];
                    case 3 -> arr[i - N / 2][j] = tmp[i][j];
                    case 4 -> arr[i][j + M / 2] = tmp[i][j];
                }
            }
        }
    }

    public static void swap() {
        int tmp = N;
        N = M;
        M = tmp;
    }

    public static int[][] copy() {
        int[][] tmp = new int[N][M];
        for(int i = 0; i < N; i++)
            tmp[i] = arr[i].clone();
        return tmp;
    }

    public static int chk(int i , int j) {
        if(i < N / 2 && j < M / 2) return 1;
        else if(i < N / 2 && j >= M / 2) return 2;
        else if(i >= N / 2 && j >= M / 2) return 3;
        else if(i >= N / 2 && j < M / 2) return 4;
        return 0;
    }
}
