package boj_algorithm._12800;

import java.util.Arrays;
import java.util.Scanner;

public class _12865_평범한배낭 {
    static class Product {
        int v, w;

        public Product(int w, int v) {
            this.v = v;
            this.w = w;
        }
    }
    static int N, K;
    static Product[] Products;
    static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        Products = new Product[N];
        cache = new int[N][K + 1];
        for(int i = 0; i < N; i++)
            Arrays.fill(cache[i], -1);
        for(int i = 0; i < N; i++)
        Products[i] = new Product(sc.nextInt(), sc.nextInt());
        System.out.println(solve(0, K));
    }

    public static int solve(int idx, int weight) {
        if(idx == N) return 0;
        int ret = cache[idx][weight];
        if(ret != -1) return ret;
        ret = solve(idx + 1, weight);
        if(weight >= Products[idx].w)
            ret = Math.max(ret, solve(idx + 1, weight - Products[idx].w) + Products[idx].v);
        return cache[idx][weight] = ret;
    }
}
