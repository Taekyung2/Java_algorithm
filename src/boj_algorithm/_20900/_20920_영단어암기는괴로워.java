package boj_algorithm._20900;

import java.io.*;
import java.util.*;

public class _20920_영단어암기는괴로워 {
    static int N, M;
    static HashMap<String, Integer> dict = new HashMap<>();
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() < M) continue;
            dict.put(s, dict.getOrDefault(s, 0) + 1);
            if(dict.get(s) == 1) list.add(s);
        }
        list.sort((s1, s2) -> {
            if (dict.get(s1) == dict.get(s2))
                if (s1.length() == s2.length()) return s1.compareTo(s2);
                else return s2.length() - s1.length();
            else return dict.get(s2) - dict.get(s1);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list)
            sb.append(s).append("\n");
        System.out.println(sb);
    }
}