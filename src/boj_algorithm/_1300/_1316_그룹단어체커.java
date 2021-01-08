package boj_algorithm._1300;

import java.util.Scanner;

public class _1316_그룹단어체커 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int ret = 0;
        for(int t = 1; t <= tc; t++) {
            boolean[] chk = new boolean[26];
            boolean c = true;
            String s = sc.next();
            for(int i = 0; i < s.length() - 1; i++) {
                if(chk[s.charAt(i) - 'a']) {
                    c = false;
                    break;
                }
                if(s.charAt(i) != s.charAt(i + 1)) {
                    chk[s.charAt(i) - 'a'] = true;
                }
            }
            if(!c || chk[s.charAt(s.length() - 1) - 'a']) continue;
            ret++;
        }
        System.out.println(ret);
    }
}