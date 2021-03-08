package boj_algorithm._20900;

import java.io.*;
import java.util.StringTokenizer;

public class _20922_겹치는건싫어 {
    static int N, K;
    static int[] arr, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        cnt = new int[100001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int l = 0, r = 0, ret = 1;
        while(r < N) {
            if(cnt[arr[r]] < K) {
                cnt[arr[r]]++;
                ret = Math.max(ret, r - l + 1);
                r++;
            } else {
                cnt[arr[l]]--;
                l++;
            }
        }
        System.out.println(ret);
    }
}
