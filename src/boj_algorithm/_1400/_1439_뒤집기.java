package boj_algorithm._1400;

import java.util.Scanner;

public class _1439_뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] cnt = new int[2];
        for(int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if(c != s.charAt(i + 1))
                cnt[(int)c - '0']++;
        }
        cnt[(int)s.charAt(s.length() - 1) - '0']++;
        System.out.println(Math.min(cnt[0], cnt[1]));
    }
}
