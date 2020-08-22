package sw_expert_academy;

import java.util.Scanner;

public class 준환이의_양팔저울 {
    static int N;
    static int[][] cache;
    static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            N = sc.nextInt();
            cache = new int[(1 << N)][(1 << N)];
            boolean[] visited = new boolean[N];
            num = new int[N];
            for(int i = 0; i < N; i++) {
                num[i] = sc.nextInt();                
            }
            sol(0,0,0, visited);
            System.out.println("#" + t + " " + cache[0][0]);
        }
    }
    static int sol(int left, int right, int sum, boolean[] visited) {
        if(left + right == (1 << N) - 1) return 1;
        if(cache[left][right] > 0) return cache[left][right];
        int ret = 0;
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(sum - num[i] < 0) {
                    ret += sol(left | (1 << i), right, sum + num[i], visited);
                }
                else {
                    ret += sol(left | (1 << i), right, sum + num[i], visited);
                    ret += sol(left, right | (1 << i), sum - num[i], visited);
                }
                visited[i] = false;
            }
        }
        return cache[left][right] = ret;
    }
}