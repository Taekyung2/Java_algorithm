package boj_algorithm._20900;

import java.util.*;

public class _20921_그렇고그런사이 {
    static int N, K;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        for (int i = 0; i < N; i++) list.add(i + 1);
        int cnt = N - 1;
        while(cnt > 0 && K > 0) {
            if(K < cnt) cnt = K;
            int point = N - cnt - 1;
            list.add(point, list.pollLast());
            K -= cnt;
            cnt--;
        }
        for(int n : list)
            System.out.print(n + " ");
    }
}