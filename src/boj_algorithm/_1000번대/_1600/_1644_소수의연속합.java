package boj_algorithm._1600;

import java.util.ArrayList;
import java.util.Scanner;

public class _1644_소수의연속합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> p = new ArrayList<>();
        boolean[] prime = new boolean[N + 1];
        prime[0] = true; prime[1] = true;
        for(int i = 2; i <= N; i++) {
            if(prime[i]) continue;
            for(int j = i + i; j <= N; j+=i)
                prime[j] = true;
        }
        for(int i = 1; i <= N; i++)
            if(!prime[i])
                p.add(i);
        int lo = 0, hi = 0, ret = 0, sum = 0;
        while(lo <= hi) {
            if(sum < N && hi < p.size()) {
                sum += p.get(hi);
                hi++;
            } else {
                if(sum == N) ret++;
                if(hi == p.size() && lo == hi) break;
                sum -= p.get(lo);
                lo++;
            }
        }
        System.out.println(ret);
    }
}
