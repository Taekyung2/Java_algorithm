package ssafy_repeat;

import java.util.Scanner;

public class Combination1 {

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

        
    }
}
