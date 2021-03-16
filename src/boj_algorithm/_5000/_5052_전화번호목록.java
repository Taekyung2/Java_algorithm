package boj_algorithm._5000;

import java.util.*;
public class _5052_전화번호목록 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            String ret = "YES";
            for(int i = 0; i < n; i++) arr[i] = sc.next();
            Arrays.sort(arr);
            for(int i = 0; i < n - 1; i++)
                if(arr[i + 1].startsWith(arr[i])) {
                    ret = "NO";
                    break;
                }
            System.out.println(ret);
        }
    }
}