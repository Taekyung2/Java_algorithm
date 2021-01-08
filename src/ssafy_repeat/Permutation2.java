package ssafy_repeat;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation2 {
    static int N, R;
    static int[] input, number;
    static boolean[] isSelected;
    static int totalCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];
        number = new int[R];

        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        permutation(0, 0);
    }

    private static void permutation(int cnt, int flag) {
        if(cnt == R) {
            totalCnt++;
            System.out.println(Arrays.toString(number));
            return;
        }
        // 앞에서 선택된 수 배제
        for(int i = 0; i < N; i++) {
            if( (flag & 1 << i) != 0 ) continue;
            number[cnt] = input[i];
            permutation(cnt + 1, flag | 1 << i); // 다음 자리의 순열 뽑기
        }
    }
}