package boj_algorithm._15400;

import java.io.*;
import java.util.*;

public class _15486_퇴사2 {
    static int N;
    static int[] T, P, cache;
    static int stoi(String s) { return Integer.parseInt(s); };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        cache = new int[N + 2];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = stoi(st.nextToken());
            P[i] = stoi(st.nextToken());
        }
        for(int i = N; i >= 1; i--) {
            if(i + T[i] > N + 1)
                cache[i] = cache[i + 1];
            else
                cache[i] = Math.max(cache[i + 1], cache[i + T[i]] + P[i]);
        }
        System.out.println(cache[1]);
    }
}
