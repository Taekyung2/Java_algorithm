package boj_algorithm._2500;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2578_빙고 {
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[5][5];
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
               map[i][j] = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < 25; i++) q.add(sc.nextInt());
        int ret = 0;
        while(!q.isEmpty() && !check()) {
            int cur = q.poll();
            loop:
            for(int i = 0; i < 5; i++)
                for(int j = 0; j < 5; j++)
                    if(map[i][j] == cur) {
                        map[i][j] = 0;
                        break loop;
                    }
            ret++;
        }
        System.out.println(ret);
    }

    static boolean check() {
        int sum = 0;
        int rd = 0, ld = 0;
        for(int i = 0; i < 5; i++) {
            int r = 0, c = 0;
            if(map[i][i] == 0) rd++;
            if(map[i][4 - i] == 0) ld++;
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 0) r++;
                if (map[j][i] == 0) c++;
            }
            if(r == 5) sum++;
            if(c == 5) sum++;
            if(rd == 5) sum++;
            if(ld == 5) sum++;
        }
        return (sum >= 3);
    }
}
