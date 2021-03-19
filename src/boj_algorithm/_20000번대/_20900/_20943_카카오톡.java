package boj_algorithm._20900;

import java.io.*;
import java.util.*;

public class _20943_카카오톡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Double, Integer> m = new HashMap<>();
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Double a = Double.parseDouble(st.nextToken());
            Double b = Double.parseDouble(st.nextToken());
            if(a == 0) m.put(Double.MAX_VALUE, m.getOrDefault(Double.MAX_VALUE, 0) + 1);
            else if(b == 0) m.put(Double.MIN_VALUE, m.getOrDefault(Double.MIN_VALUE, 0) + 1);
            else m.put(a / b, m.getOrDefault(a / b, 0) + 1);
        }
        long ret = 0;
        for(int cnt : m.values()) {
            ret += (long) (N - cnt) * cnt;
            N -= cnt;
        }
        System.out.println(ret);
    }
}

