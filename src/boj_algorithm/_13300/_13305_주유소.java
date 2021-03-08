package boj_algorithm._13300;

import java.util.Scanner;

public class _13305_주유소 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] d = new long[N - 1];
        long[] c = new long[N];
        for(int i = 0; i < N - 1; i++)
            d[i] = sc.nextLong();
        for(int i = 0; i < N; i++)
            c[i] = sc.nextLong();

        long ret = 0;
        int cur = 0;
        int next = 1;
        while(next < N) {
            if(c[cur] >= c[next] || next == N - 1) {
                for(int i = cur; i < next; i++)
                    ret += c[cur] * d[i];
                cur = next;
            }
            next++;
        }
        System.out.println(ret);
    }
}
