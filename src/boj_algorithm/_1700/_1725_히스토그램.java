package boj_algorithm._1700;

import java.io.*;

public class _1725_히스토그램 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        System.out.println(divide(0, N - 1));
    }

    static long divide(int l, int r) {
        if(l == r) return arr[r];
        int mid = (l + r) / 2;
        long ret = Math.max(divide(l , mid), divide(mid + 1, r));
        int lo = mid, hi = mid + 1;
        long height = Math.min(arr[lo], arr[hi]);
        ret = Math.max(ret, height * 2);
        while(l < lo || hi < r) {
            if(hi < r && (lo == l || arr[lo - 1] < arr[hi + 1])) {
                ++hi;
                height = Math.min(height, arr[hi]);
            } else {
                --lo;
                height = Math.min(height, arr[lo]);
            }
            ret = Math.max(ret, height * (hi - lo + 1));
        }
        return ret;
    }
}
