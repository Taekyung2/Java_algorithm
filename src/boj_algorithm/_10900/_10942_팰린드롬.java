package boj_algorithm._10900;

import java.io.*;
import java.util.*;

public class _10942_팰린드롬 {
    static int N, M;
    static int[] arr;
    static boolean[][] cache;

    static int stoi(String s) { return Integer.parseInt(s); }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        arr = new int[2002];
        cache = new boolean[2002][2002];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            arr[i] = stoi(st.nextToken());
        for(int i = 1; i <= N; i++) {
            cache[i][i] = true;
            cache[i][i + 1] = (arr[i] == arr[i + 1]);
        }
        for(int i = 3; i <= N; i++)
            for(int j = 1; j <= N - i + 1; j++)
                cache[j][j + i - 1] = cache[j + 1][j + i - 2] && (arr[j] == arr[j + i - 1]);
        M = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = stoi(st.nextToken());
            int e = stoi(st.nextToken());
            int ret = cache[s][e] ? 1 : 0;
            sb.append(ret).append("\n");
        }
        System.out.println(sb);
    }
}
