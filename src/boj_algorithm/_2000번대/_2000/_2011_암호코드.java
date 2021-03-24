package boj_algorithm._2000번대._2000;

import java.util.Scanner;

public class _2011_암호코드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int dp[] = new int[s.length() + 1];
        int mod = 1000000;
        dp[0] = dp[1] = 1;
        for (int j = 2; j <= s.length(); j++) {
            int i = j-1;
            if (s.charAt(i) > '0')
                dp[j] = dp[j-1];

            int num = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
            if ( num >= 10 && num <= 26 )
                dp[j] = (dp[j] + dp[j-2]) % mod;
        }
        System.out.println(s.charAt(0)=='0' ? 0 : dp[s.length()]);
    }
}