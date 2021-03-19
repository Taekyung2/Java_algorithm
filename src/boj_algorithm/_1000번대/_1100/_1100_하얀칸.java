package boj_algorithm._1100;

import java.util.Scanner;

public class _1100_하얀칸 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        for(int i = 0; i < 8; i++) {
            String s = sc.next();
            for(int j = 0; j < 8; j++)
                if((i + j) % 2 == 0 && s.charAt(j) == 'F') cnt++;
        }
        System.out.println(cnt);
    }
}
