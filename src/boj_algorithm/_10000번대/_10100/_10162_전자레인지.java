package boj_algorithm._10100;

import java.util.Scanner;

public class _10162_전자레인지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] time = {300, 60, 10};
        int[] ret = new int[3];
        for(int i = 0; i < 3; i++) {
            ret[i] = T / time[i];
            T %= time[i];
        }
        if(T == 0)
            for(int n : ret)
                System.out.print(n + " ");
        else
            System.out.println(-1);
    }
}