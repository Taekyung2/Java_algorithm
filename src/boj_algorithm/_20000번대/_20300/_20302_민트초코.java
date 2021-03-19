package boj_algorithm._20300;

import java.io.*;
import java.util.StringTokenizer;

public class _20302_민트초코 {
    static int[] prime;
    final static String t = "mint chocolate", f = "toothpaste";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char op = '*';
        prime = new int[100001];
        boolean zero = false;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            if(i > 0) op = st.nextToken().charAt(0);
            int n = Math.abs(Integer.parseInt(st.nextToken()));
            if(n == 0) zero = true;
            count(op, n);
        }
        if(zero) {
            System.out.println(t);
            return;
        }
        for(int n : prime)
            if(n < 0) {
                System.out.println(f);
                return;
            }
        System.out.println(t);
    }

    static void count(char op, int n) {
        int r = (int) Math.sqrt(n);
        for(int i = 2; i <= r; i++) {
            while(n % i == 0) {
                n /= i;
                prime[i] = (op == '*') ? ++prime[i] : --prime[i];
            }
            if(n == 1) break;
        }
        if(n > 1)
            prime[n] = (op == '*') ? ++prime[n] : --prime[n];
    }
}
