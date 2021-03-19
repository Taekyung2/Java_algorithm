package boj_algorithm._3000;

import java.util.Scanner;

public class _3003_킹퀸룩비숍나이트폰 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {1, 1, 2, 2, 2, 8};
        for(int i = 0; i < 6; i++)
            System.out.print((a[i] - sc.nextInt()) + " ");
    }
}
