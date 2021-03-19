package boj_algorithm._20500;

import java.util.Scanner;

public class _20528_끝말잇기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String f = sc.next();
        char c = f.charAt(f.length() - 1);
        for(int i = 1; i < n; i++) {
            String s = sc.next();
            if(c == s.charAt(s.length() - 1))
                continue;
            else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}