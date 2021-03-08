package boj_algorithm._11600;

import java.io.*;
import java.util.StringTokenizer;

public class _11660_구간합구하기5 {
    static int stoi(String s) { return Integer.parseInt(s); }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++)
                arr[i][j] = stoi(st.nextToken());
        }
        for(int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                arr[i][j] += arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = stoi(st.nextToken());
            int x1 = stoi(st.nextToken());
            int y2 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken());
            sb.append(arr[y2][x2] - arr[y1 - 1][x2] - arr[y2][x1 - 1] + arr[y1 - 1][x1 - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
