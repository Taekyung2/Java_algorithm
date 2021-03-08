package boj_algorithm._20300;

import java.util.*;

public class _20304_비밀번호제작 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[1000001];
        Arrays.fill(arr, Integer.MIN_VALUE);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < M; i++) {
            int n = sc.nextInt();
            arr[n] = 0;
            q.add(n);
        }
        int ret = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 0; i < 20; i++) {
                int next = cur ^ (1 << i);
                if(next > N || arr[next] != Integer.MIN_VALUE) continue;
                arr[next] = arr[cur] + 1;
                q.add(next);
                ret = Math.max(ret, arr[next]);
            }
        }
        System.out.println(ret);
    }
}
