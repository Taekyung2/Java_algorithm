package boj_algorithm._5500;

import java.util.Scanner;

public class _5554_심부름가는길 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = 0;
        for(int i = 0; i < 4; i++)
            s += sc.nextInt();
        System.out.println(s / 60);
        System.out.println(s % 60);
    }
}
