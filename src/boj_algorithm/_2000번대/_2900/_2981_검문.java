package boj_algorithm._2900;

import java.util.Arrays;
import java.util.Scanner;

public class _2981_검문 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int g = arr[1] - arr[0];
        for(int i = 1; i < N - 1; i++)
            g = gcd(g, arr[i + 1] - arr[i]);
        for(int i = 2; i <= g; i++) {
            if(g % i == 0) System.out.print(i + " ");
        }
    }

    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}