package boj_algorithm._3000;

import java.util.Scanner;

public class _3040_백설공주와일곱난쟁이 {
    static int[] arr = new int[9];
    static int[] pick = new int[7];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++)
            arr[i] = sc.nextInt();
        comb(0, 0);
    }

    static void comb(int idx, int cnt) {
        if(cnt == 7) {
            int sum = 0;
            for(int a : pick)
                sum += a;
            if(sum == 100) for(int a : pick) System.out.println(a);
            return;
        }
        if(idx == 9) return;
        pick[cnt] = arr[idx];
        comb(idx + 1, cnt + 1);
        comb(idx + 1, cnt);
    }
}
