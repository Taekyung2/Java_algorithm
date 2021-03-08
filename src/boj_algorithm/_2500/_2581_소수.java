package boj_algorithm._2500;

import java.util.Scanner;

public class _2581_소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] prime = new boolean[10001];
        prime[0] = prime[1] = true;
        for(int i = 2; i <= 10000; i++) {
            if(prime[i]) continue;
            for(int j = i + i; j <= 10000; j += i) {
                prime[j] = true;
            }
        }
        int sum = 0;
        int min = 0;
        for(int i = M; i >= N; i--) {
            if(!prime[i]) {
                sum += i;
                min = i;
            }
        }
        if(sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }
}
