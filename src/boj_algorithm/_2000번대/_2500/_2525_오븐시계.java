package boj_algorithm._2500;

import java.time.LocalTime;
import java.util.Scanner;

public class _2525_오븐시계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        LocalTime t = LocalTime.of(a, b);
        t = t.plusMinutes(c);
        System.out.println(t.getHour() + " " + t.getMinute());
    }
}