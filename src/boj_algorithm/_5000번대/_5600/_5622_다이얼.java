package boj_algorithm._5600;

import java.util.Scanner;

public class _5622_다이얼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] arr = new int[10];
        int ret = 0;
        for(int i = 0; i < 10; i++)
            arr[i] = i + 2;
        for(int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'A';
            if(n < 15) {
                ret += arr[n / 3 + 1];
            }
            else if(n < 19) {
                ret += arr[6];
            }
            else if(n < 22) {
                ret += arr[7];
            }
            else if(n < 26) {
                ret += arr[8];
            }
        }
        System.out.println(ret);
    }
}