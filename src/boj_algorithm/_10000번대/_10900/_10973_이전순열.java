package boj_algorithm._10900;

import java.util.Scanner;

public class _10973_이전순열 {
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        if(prevPermutation()) {
            for(int a : arr)
                System.out.print(a + " ");
        }
        else
            System.out.println(-1);
    }

    private static boolean prevPermutation() {
        int i = N - 1;
        while(i > 0 && arr[i - 1] <= arr[i]) --i;
        if(i == 0) return false;

        int j = N - 1;
        while(arr[i - 1] <= arr[j]) --j;

        int tmp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = tmp;

        int k = N - 1;
        while(i < k) {
            tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
            ++i;
            --k;
        }
        return true;
    }
}