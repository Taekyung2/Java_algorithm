package boj_algorithm._5600;

import java.io.*;
import java.util.ArrayList;

public class _5639_이진검색트리 {
    static ArrayList<Integer> pre = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String n = br.readLine();
            if(n == null || n.equals("")) break;
            pre.add(Integer.parseInt(n));
        }
        solve(0, pre.size() - 1);
    }

    static void solve(int s, int e) {
        if(s > e) return;
        int r = s + 1;
        for(; r <= e; r++) if(pre.get(s) < pre.get(r)) break;
        solve(s + 1, r - 1);
        solve(r, e);
        System.out.println(pre.get(s));
    }
}