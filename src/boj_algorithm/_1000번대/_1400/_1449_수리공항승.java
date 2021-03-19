package boj_algorithm._1400;

import java.util.Scanner;

public class _1449_수리공항승 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int cnt = 0;
        boolean[] arr = new boolean[1001];
        for(int i = 0; i < N; i++)
            arr[sc.nextInt()] = true;
        int idx = 0;
        while(idx <= 1000) {
            if(arr[idx]) {
                cnt++;
                idx += L;
                continue;
            }
            idx++;
        }
        System.out.println(cnt);
    }
}
