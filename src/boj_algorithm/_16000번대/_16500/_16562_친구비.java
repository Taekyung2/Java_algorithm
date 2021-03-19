package boj_algorithm._16500;

import java.util.Scanner;
import java.util.stream.IntStream;

public class _16562_친구비 {
    static int N, M, K, cnt = 0, ret = 0;
    static int[] A;
    static int[] parent;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        A = new int[N + 1];
        check = new boolean[N + 1];
        for(int i = 1; i <= N; i++)
            A[i] = sc.nextInt();
        parent = IntStream.range(0, N + 1).toArray();
        for(int i = 0; i < M; i++)
            union(sc.nextInt(), sc.nextInt());
        for(int i = 1; i <= N; i++) {
            int p = find(i);
            if(check[p]) {
                cnt++;
                continue;
            }
            check[p] = true;
            cnt++;
            ret += A[p];
        }
        if(ret > K || cnt != N) System.out.println("Oh no");
        else System.out.println(ret);
    }

    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return;
        if(A[a] > A[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
}