package boj_algorithm._3200;

import java.util.Arrays;
import java.util.Scanner;

public class _3273_두수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        int X = sc.nextInt();
        Arrays.sort(arr);
        int l = 0, r = N - 1, ret = 0;
        while(l < r) {
            if(arr[l] + arr[r] <= X) {
                if(arr[l] + arr[r] == X) ret++;
                l++;
            } else
                r--;
        }
        System.out.println(ret);
    }
}