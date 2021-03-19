package boj_algorithm._13300;

import java.util.Scanner;

public class _13300_방배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] arr = new int[2][7];
        int ret = 0;
        for(int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int g = sc.nextInt();
            arr[s][g]++;
        }
        for(int i = 0; i < 2; i++) {
            for(int j = 1; j <= 6; j++) {
                ret += arr[i][j] / K;
                if(arr[i][j] % K != 0) ret++;
            }
        }
        System.out.println(ret);
    }
}
