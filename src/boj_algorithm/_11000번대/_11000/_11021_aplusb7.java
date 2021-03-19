package boj_algorithm._11000;

import java.util.Scanner;

public class _11021_aplusb7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            System.out.println("Case #" + t + ": " + (sc.nextInt() + sc.nextInt()));
        }
    }
}