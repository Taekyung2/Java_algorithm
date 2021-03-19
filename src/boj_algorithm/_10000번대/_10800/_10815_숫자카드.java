package boj_algorithm._10800;

import java.io.*;
import java.util.*;

public class _10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> s = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            s.add(Integer.parseInt(st.nextToken()));
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            if(s.contains(Integer.parseInt(st.nextToken()))) sb.append(1 + " ");
            else sb.append(0 + " ");
        }
        System.out.println(sb);
    }
}
