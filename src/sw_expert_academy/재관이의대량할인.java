package sw_expert_academy;

import java.util.Arrays;
import java.util.Scanner;
 
public class 재관이의대량할인 {
 
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int TC = sc.nextInt();
        for(int tc=1; tc<=TC; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int n=0; n<N; n++) {
                arr[n] = sc.nextInt();
            }
            Arrays.sort(arr);
            int sum = 0;
            for(int i =1; i<=N; i++) {
                if(i%3==0) {
                    continue;
                }else {
                    sum+=arr[N-i];
                }
            }
            System.out.println("#"+tc+" "+sum);
        }
    }
}