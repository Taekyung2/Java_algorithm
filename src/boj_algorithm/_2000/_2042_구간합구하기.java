package boj_algorithm._2000;

import java.io.*;
import java.util.StringTokenizer;

public class _2042_구간합구하기 {
    static int N, M, K;
    static class FenwickTree {
        long[] tree;
        FenwickTree(int N) {
            tree = new long[N + 1];
        }
        long sum(int pos) {
            long ret = 0;
            while(pos > 0) {
                ret += tree[pos];
                pos &= (pos - 1);
            }
            return ret;
        }

        void add(int pos, long val) {
            while(pos < tree.length) {
                tree[pos] += val;
                pos += (pos & -pos);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        long[] tmp = new long[N + 1];
        FenwickTree ft = new FenwickTree(N);
        for(int i = 1; i <= N; i++) {
            tmp[i] = Long.parseLong(br.readLine());
            ft.add(i, tmp[i]);
        }
        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == '1') {
                ft.add(b, c - tmp[b]);
                tmp[b] = c;
            }
            else
                sb.append(ft.sum((int)c) - ft.sum(b - 1)).append("\n");
        }
        System.out.println(sb);
    }
}
