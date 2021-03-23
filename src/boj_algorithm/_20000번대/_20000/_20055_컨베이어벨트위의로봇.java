package boj_algorithm._20000번대._20000;

import java.util.Scanner;

public class _20055_컨베이어벨트위의로봇 {
    static int N, K, ret = 1;
    static int[] A;
    static boolean[] robot;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        A = new int[2 * N + 1];
        robot = new boolean[N + 1];
        for(int i = 1; i <= 2 * N; i++)
            A[i] = sc.nextInt();
        while(true) {
            rotate();
            move();
            if(!robot[1] && A[1] > 0) {
                robot[1] = true;
                A[1]--;
            }
            if(count() >= K)
                break;
            ret++;
        }
        System.out.println(ret);
    }

    static void rotate() {
        for(int i = N - 1; i > 0; i--) {
            if(robot[i]) {
                robot[i + 1] = true;
                robot[i] = false;
            }
        }
        robot[N] = false;
        int tmp = A[2 * N];
        for(int i = 2 * N; i > 1; i--)
            A[i] = A[i - 1];
        A[1] = tmp;
    }

    static void move() {
        for(int i = N - 1; i > 0; i--) {
            if(robot[i] && !robot[i + 1] && A[i + 1] > 0) {
                robot[i + 1] = true;
                robot[i] = false;
                A[i + 1]--;
            }
        }
        robot[N] = false;
    }

    static int count() {
        int ans = 0;
        for(int i = 1; i <= 2 * N; i++)
            if(A[i] == 0) ans++;
        return ans;
    }
}
