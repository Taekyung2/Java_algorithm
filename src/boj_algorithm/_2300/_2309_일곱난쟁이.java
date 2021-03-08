package boj_algorithm._2300;

import java.util.Arrays;
import java.util.Scanner;

public class _2309_일곱난쟁이 {
    static int[] pick, len;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pick = new int[7];
        len = new int[9];
        for(int i = 0; i < 9; i++)
            len[i] = sc.nextInt();
        comb(0, 0);
    }

    private static void comb(int cnt, int cur) {
        if(cnt == 7) {
            int sum = 0;
            for(int i = 0; i < 7; i++) {
                sum += pick[i];
            }
            if(sum == 100) {
                Arrays.sort(pick);
                for(int n : pick)
                    System.out.println(n);
                return;
            }
            return;
        }

        for(int i = cur; i < 9; i++) {
            pick[cnt] = len[i];
            comb(cnt + 1, i + 1);
        }
    }
}