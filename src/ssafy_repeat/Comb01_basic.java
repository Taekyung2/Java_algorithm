package ssafy_repeat;

import java.util.Arrays;
import java.util.Scanner;

public class Comb01_basic {
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
        combination(0, 0);
    }

    // 현재 위치에 조합할 수 선택
    private static void combination(int cnt, int cur) {
        if(cnt == R) {
            System.out.println(Arrays.toString(number));
            return;
        }
        for(int i = cur; i < N; i++) {
            number[cnt] = input[i];
            // 현재 수의 다음 수부터 시작하도록 전달
            combination(cnt + 1, i + 1);
        }
    }
}
