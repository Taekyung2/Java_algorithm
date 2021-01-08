package ssafy_repeat;

import java.util.Arrays;
import java.util.Scanner;

public class Comb02_basic {
    static int N, R;
    static int[] input, number;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        number = new int[R];

        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        combination(N, R);
    }

    // 현재 위치에 조합할 수 선택
    private static void combination(int n, int r) {
        if(r == 0) {
            System.out.println(Arrays.toString(number));
            return;
        }
        if(n < r) return;
        number[r - 1] = input[n - 1];
        // 선택
        combination(n - 1, r - 1);
        // 비선택
        combination(n - 1, r);
    }
}
