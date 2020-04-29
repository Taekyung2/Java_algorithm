package sw_expert_academy;

import java.util.Scanner;

public class 자기_방으로_돌아가기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            int N = sc.nextInt();
            int ret = 1;
            int[] arr = new int[201];
            for(int j = 0; j < N; j++) {
                int from = sc.nextInt(); int to = sc.nextInt();
                from = (from + 1) / 2;
                to = (to + 1) / 2;
                if(to >= from) for(int i = from; i <= to; i++) arr[i]++;
                else for(int i = to; i <= from; i++) arr[i]++;
            }
            for(int i = 0; i < 201; i++)
            	ret = Math.max(ret, arr[i]);
            System.out.println("#" + t + " " + ret);
        }
        sc.close();
    }
}