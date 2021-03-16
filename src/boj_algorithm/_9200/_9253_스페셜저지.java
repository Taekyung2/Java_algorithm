package boj_algorithm._9200;

import java.util.Scanner;

public class _9253_스페셜저지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next(), c = sc.next();
        if(a.contains(c) && b.contains(c))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
