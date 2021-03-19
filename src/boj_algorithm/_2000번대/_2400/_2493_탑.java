package boj_algorithm._2400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _2493_탑 {
    static class Pair {
        int idx, n;
        Pair(int idx, int n) {
            this.idx = idx;
            this.n = n;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[N];
        int[] ret = new int[N];
        StringTokenizer st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = new Pair(i + 1, Integer.parseInt(st.nextToken()));
        ArrayDeque<Pair> stk = new ArrayDeque<>();
        for(int i = N - 1; i >= 0; i--) {
            while(!stk.isEmpty() && stk.peekLast().n < arr[i].n)
                ret[stk.pollLast().idx - 1] = arr[i].idx;
            stk.addLast(arr[i]);
        }
        for(int n : ret)
            sb.append(n).append(" ");
        System.out.println(sb);
    }
}