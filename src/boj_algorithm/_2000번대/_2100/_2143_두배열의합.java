package boj_algorithm._2100;

import java.util.*;

public class _2143_두배열의합 {
    static long T, ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextLong();
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++) A[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] B = new int[m];
        for(int i = 0; i < m; i++) B[i] = sc.nextInt();
        ArrayList<Long> a_part = new ArrayList<>(n * n);
        ArrayList<Long> b_part = new ArrayList<>(m * m);
        sum(a_part, A, n);
        sum(b_part, B, m);
        Collections.sort(b_part);
        for(long a : a_part)
            ret += upperBound(b_part, T - a) - lowerBound(b_part, T - a);
        System.out.println(ret);
    }

    static int lowerBound(ArrayList<Long> list, long n) {
        int lo = 0, hi = list.size();
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(list.get(mid) >= n)
                hi = mid;
            else
                lo = mid + 1;
        }
        return hi;
    }

    static int upperBound(ArrayList<Long> list, long n) {
        int lo = 0, hi = list.size();
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(list.get(mid) <= n)
                lo = mid + 1;
            else
                hi = mid;
        }
        return hi;
    }

    static void sum(ArrayList<Long> list, int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            long sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }
    }
}