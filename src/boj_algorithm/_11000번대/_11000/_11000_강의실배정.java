package boj_algorithm._11000;

import java.io.*;
import java.util.*;

public class _11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), 0});
            list.add(new int[]{Integer.parseInt(st.nextToken()), 1});
        }
        list.sort((l1, l2) -> {
            if(l1[0] == l2[0]) return l2[1] - l1[1];
            return l1[0] - l2[0];
        });
        int cnt = 0, ret = 0;
        for(int[] i : list) {
            if(i[1] == 0) cnt++;
            else if(i[1] == 1) cnt--;
            ret = Math.max(ret, cnt);
        }
        System.out.println(ret);
    }
}