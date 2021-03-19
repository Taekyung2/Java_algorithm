package boj_algorithm._1000;

import java.util.Arrays;
import java.util.Scanner;

public class _1037_약수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int ret = 0;
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        if(n == 1) ret = (int) Math.pow(arr[0], 2);
        else ret = arr[0] * arr[n - 1];
        System.out.println(ret);
    }
}
