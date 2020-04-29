package sw_expert_academy;

import java.util.Scanner;

public class 방향전환 {
    static int x, xx, y, yy;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            x = sc.nextInt(); y = sc.nextInt();
            xx = sc.nextInt(); yy = sc.nextInt();
            System.out.println("#" + t + " " + Math.min(sol(x, y, 1), sol(x, y, 0)));
        }
        sc.close();
    }
    
    static int sol(int x, int y, int dir) {
        int cnt = 0;
        while(!(y == yy && x == xx)) {
            if(dir == 1) {
                if (y > yy) --y;
                else ++y;
            }
            else {
            	if (x > xx) --x;
            	else ++x;
            }
            cnt++;
            dir = Math.abs(dir - 1);
        }
        return cnt;
    }
}