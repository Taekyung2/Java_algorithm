package boj_algorithm._11700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _11728_배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> al = new ArrayList<>(N + M);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            al.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            al.add(Integer.parseInt(st.nextToken()));
        Collections.sort(al);
        StringBuilder sb = new StringBuilder();
        for(int a : al)
            sb.append(a + " ");
        System.out.println(sb);
    }
}
