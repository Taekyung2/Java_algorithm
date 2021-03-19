package boj_algorithm._1000;

import java.util.Scanner;

public class _1002_터렛 {
    static class P {
        int x, y, r;

        public P(int x,int y, int r) {
            this.x = x ;
            this.y = y;
            this.r = r;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            P p1 = new P(sc.nextInt(), sc.nextInt(), sc.nextInt());
            P p2 = new P(sc.nextInt(), sc.nextInt(), sc.nextInt());
            double d = distance(p1, p2);
            if(d == 0) {
                if(p1.r == p2.r)
                    System.out.println(-1);
                else
                    System.out.println(0);
            }
            else {
                if (p1.r + p2.r < d) {
                    System.out.println(0);
                } else if (p1.r + p2.r == d) {
                    System.out.println(1);
                } else if (Math.abs(p1.r - p2.r) == d) {
                    System.out.println(1);
                } else if (Math.abs(p1.r - p2.r) > d){
                    System.out.println(0);
                } else {
                System.out.println(2);
                }
            }
        }
    }

    public static double distance(P p1, P p2) {
        int a = p1.x - p2.x;
        int b = p1.y - p2.y;
        return Math.sqrt(a * a + b * b);
    }
}
