package boj_algorithm._1500;

import java.io.*;
import java.util.StringTokenizer;

public class _1517_버블소트 {
    static long ret = 0;
    static int[] tmp = new int[500001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        mergeSort(arr, 0, N - 1);
        System.out.println(ret);
    }

    static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int i, j, k;
        i = left; j = mid + 1; k = 0;
        while(i <= mid && j <= right) {
            if (arr[i] <= arr[j])
                tmp[k++] = arr[i++];
            else {
                ret += mid - i + 1;
                tmp[k++] = arr[j++];
            }
        }
        while(i <= mid) tmp[k++] = arr[i++];
        while(j <= right) tmp[k++] = arr[j++];
        for(int p = left; p <= right; p++) arr[p] = tmp[p - left];
    }
}
