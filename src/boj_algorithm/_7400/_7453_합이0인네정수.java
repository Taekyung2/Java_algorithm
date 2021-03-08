package boj_algorithm._7400;

import java.io.*;
import java.util.*;

public class _7453_합이0인네정수 {
    static int stoi(String s) { return Integer.parseInt(s); }
    static long stol(String s) { return Long.parseLong(s); }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  stoi(br.readLine());
        long ret = 0;
        long[] a = new long[n], b = new long[n], c = new long[n], d = new long[n];
        long[] ab = new long[n * n], cd = new long[n * n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = stol(st.nextToken());
            b[i] = stol(st.nextToken());
            c[i] = stol(st.nextToken());
            d[i] = stol(st.nextToken());
        }
        int idx = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                ab[idx] = a[i] + b[j];
                cd[idx] = c[i] + d[j];
                idx++;
            }
        Arrays.sort(ab);
        Arrays.sort(cd);
        for(long m : ab)
            ret += upperBound(cd, -m) - lowerBound(cd, -m);
        System.out.println(ret);
    }

    static int lowerBound(long[] arr, long n) {
        int lo = 0, hi = arr.length;
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(arr[mid] >= n) hi = mid;
            else lo = mid + 1;
        }
        return hi;
    }

    static int upperBound(long[] arr, long n) {
        int lo = 0, hi = arr.length;
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(arr[mid] <= n) lo = mid + 1;
            else hi = mid;
        }
        return hi;
    }
}
