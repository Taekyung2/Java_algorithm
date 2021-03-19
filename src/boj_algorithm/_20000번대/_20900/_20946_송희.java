package boj_algorithm._20900;

import java.io.*;
import java.util.*;

public class _20946_송희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        boolean[] prime = new boolean[1_000_001];

        Arrays.fill(prime, true);
        prime[1] = false;
        for (int i = 2; i <= 1_000_000; i++) {
            if (!prime[i]) continue;
            for (int j = 2; i * j <= 1_000_000; j++)
                prime[i * j] = false;
        }

        List<Long> list = new ArrayList<>();
        for (long i = 2; i * i <= N; i++) {
            if (!prime[(int) i]) continue;
            while (N % i == 0) {
                list.add(i);
                N /= i;
            }
        }
        if (N != 1) list.add(N);
        if (list.size() < 2) {
            System.out.println(-1);
            return;
        }
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < list.size()) {
            long num = list.get(idx++) * list.get(idx++);
            if (idx == list.size() - 1) num *= list.get(idx++);
            sb.append(num).append(' ');
        }
        System.out.println(sb.toString());
    }
}
