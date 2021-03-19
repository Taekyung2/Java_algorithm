package boj_algorithm._20500;

import java.util.Scanner;

public class _20529_가장가까운세사람의심리적거리 {
    static String[] arr;
    static int[] picked;
    static int N, min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            N = sc.nextInt();
            arr = new String[N];
            picked = new int[N];
            min = 987654321;
            for(int i = 0; i < N; i++)
                arr[i] = sc.next();
            pick(0, 0);
            System.out.println(min);
        }
    }

    public static void pick(int cnt, int cur) {
        if(min == 0) return;
        if(cnt == 3) {
            int tmp = distance();
            min = Math.min(min, tmp);
            return;
        }

        for(int i = cur; i < N; i++) {
            picked[cnt] = i;
            pick(cnt + 1, i + 1);
        }
    }

    public static int distance() {
        return  calc(arr[picked[0]], arr[picked[1]]) +
                calc(arr[picked[0]], arr[picked[2]]) +
                calc(arr[picked[1]], arr[picked[2]]);
    }

    public static int calc(String a, String b) {
        int cnt = 0;
        for(int i = 0; i < 4; i++)
            if(a.charAt(i) != b.charAt(i))
                cnt++;
        return cnt;
    }
}