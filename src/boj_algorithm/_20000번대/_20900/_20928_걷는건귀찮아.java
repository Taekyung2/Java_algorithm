package boj_algorithm._20900;

import java.io.*;
import java.util.*;

public class _20928_걷는건귀찮아 {
    static class Man {
        int s, e;
        Man(int s) {
            this.s = s;
        }
    }
    static int N, M, ret = Integer.MAX_VALUE;
    static Man[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Man[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = new Man(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i].e = arr[i].s + Integer.parseInt(st.nextToken());
        Arrays.sort(arr, (m1, m2)-> {
            if(m1.s == m2.s) return m1.e - m2.e;
            return m1.s - m2.s;
        });
        solve(0, 0);
        System.out.println(ret == Integer.MAX_VALUE ? -1 : ret);
    }

    static void solve(int cur, int cnt) {
        if(cnt >= N) return;
        if(arr[cur].e >= M) {
            ret = Math.min(ret, cnt);
            return;
        }
        int max = 0, end = 0;
        for(int i = cur + 1; i < N; i++) {
            if (arr[i].s > arr[cur].e) break;
            if(arr[i].e > end) {
                end = arr[i].e;
                max = i;
            }
        }
        solve(max, cnt + 1);
    }
}