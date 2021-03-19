package boj_algorithm._10800;

import java.util.Arrays;
import java.util.Scanner;

public class _10819_차이를최대로 {
    static int N, ret = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        do {
            int sum = 0;
            for(int i = 0; i < N - 1; i++)
                sum += Math.abs(arr[i] - arr[i + 1]);
            ret = Math.max(ret, sum);
        } while(nextPermutation());
        System.out.println(ret);
    }

    private static boolean nextPermutation() {
        int i = N - 1;
        while(i > 0 && arr[i - 1] >= arr[i]) --i;
        if(i == 0) return false;

        int j = N - 1;
        while(arr[i - 1] >= arr[j]) --j;

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