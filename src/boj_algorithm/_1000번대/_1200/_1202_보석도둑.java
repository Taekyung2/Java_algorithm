package boj_algorithm._1200;

import java.io.*;
import java.util.*;

public class _1202_보석도둑 {
    static class Jewel {
        int v, c;
        Jewel(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewel[] j = new Jewel[N];
        int[] bag = new int[K];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            j[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i < K; i++) bag[i] = Integer.parseInt(br.readLine());
        Arrays.sort(j, Comparator.comparingInt(j2 -> j2.v));
        Arrays.sort(bag);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int idx = 0;
        long ret = 0;
        for(int i = 0; i < K; i++) {
            while(idx < N && bag[i] >= j[idx].v) pq.add(j[idx++].c);
            if(!pq.isEmpty()) ret += pq.poll();
        }
        System.out.println(ret);
    }
}
