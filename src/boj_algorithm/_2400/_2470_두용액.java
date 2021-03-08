package boj_algorithm._2400;

import java.io.*;
import java.util.*;

public class _2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int l = 0, r = N - 1, ret = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while(l < r) {
            int cur = arr[r] + arr[l];
            if(Math.abs(cur) < Math.abs(ret)) {
                ret = cur;
                ans[0] = arr[l];
                ans[1] = arr[r];
            }
            if(cur <= 0) l++;
            else r--;

        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
