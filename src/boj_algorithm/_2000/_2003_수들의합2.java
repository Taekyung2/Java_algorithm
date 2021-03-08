package boj_algorithm._2000;

import java.io.*;
import java.util.StringTokenizer;

public class _2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int sum = 0, l = 0, r = 0, ret = 0;
        while(true) {
            if(sum >= M) {
                if(sum == M) ret++;
                sum -= arr[l];
                l++;
            }
            else {
                if(r == N) break;
                sum += arr[r];
                r++;
            }
        }
        System.out.println(ret);
    }
}