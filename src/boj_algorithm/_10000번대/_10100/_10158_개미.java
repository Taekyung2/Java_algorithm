package boj_algorithm._10100;

import java.util.Scanner;

public class _10158_개미 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt(), h = sc.nextInt(), p = sc.nextInt(), q = sc.nextInt(), t = sc.nextInt();
        int x = (p + t) % (2 * w), y = (q + t) % (2 * h);
        if(x > w) x = 2 * w - x;
        if(y > h) y = 2 * h - y;
        System.out.println(x + " " + y);
    }
}
