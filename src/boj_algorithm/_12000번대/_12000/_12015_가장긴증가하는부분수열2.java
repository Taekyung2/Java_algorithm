package boj_algorithm._12000;

import java.io.*;
import java.util.StringTokenizer;

public class _12015_가장긴증가하는부분수열2 {
    static int N;
    static int[] ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ret = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        ret[0] = Integer.parseInt(st.nextToken());
        int r = 1;
        for(int i = 1; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur > ret[r - 1]) ret[r++] = cur;
            else {
                int lo = 0;
                int hi = r;
                int mid = 0;
                while(lo < hi) {
                    mid = (lo + hi) / 2;
                    if(ret[mid] < cur) lo = mid + 1;
                    else  hi = mid;
                }
                ret[hi] = cur;
            }
        }
        System.out.println(r);
    }
}
