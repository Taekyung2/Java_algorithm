package boj_algorithm._6588;

import java.util.Scanner;

public class _6588_골드바흐의추측 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[1000001];
        prime[0] = true;
        prime[1] = true;
        for(int i = 2; i < 1000001; i++) {
            if(prime[i]) continue;
            for(int j = i + i; j < 1000001; j += i) {
                prime[j] = true;
            }
        }
        loop:
        while(true) {
            int n = sc.nextInt();
            if(n == 0) break;
            int tmp = n;
            while(tmp > 2) {
                if(!prime[tmp] && !prime[n - tmp] && n - tmp != 2) {
                    System.out.println(n + " = " + (n - tmp) + " + " + tmp);
                    continue loop;
                }
                tmp--;
            }
            System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}