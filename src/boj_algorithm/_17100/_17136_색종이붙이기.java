package boj_algorithm._17100;

import java.util.Scanner;

public class _17136_색종이붙이기 {
    static int ret = 26;
    static int[] paper = new int[6];
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[10][10];
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 10; j++)
                map[i][j] = sc.nextInt();
        backtrack(0);
        System.out.println((ret == 26) ? -1 : ret);
    }

    static void backtrack(int cur) {
        if(cur > ret) return;
        int[] s = chk();
        if(s[0] == -1) {
            ret = Math.min(ret, cur);
            return;
        }
        for(int k = 5; k >= 1; k--) {
            if(paper[k] > 4) continue;
            if(!cover(s[0], s[1], k)) continue;
            for(int i = 0; i < k; i++)
                for(int j = 0; j < k; j++)
                    map[s[0] + i][s[1] + j] = 0;
            paper[k]++;
            backtrack(cur + 1);
            for(int i = 0; i < k; i++)
                for(int j = 0; j < k; j++)
                    map[s[0] + i][s[1] + j] = 1;
            paper[k]--;
        }
    }

    static boolean cover(int y, int x, int k) {
       for(int i = 0; i < k; i++)
           for(int j = 0; j < k; j++) {
               int ny = y + i, nx = x + j;
               if(ny < 0 || nx < 0 || ny >= 10 || nx >= 10 || map[ny][nx] == 0) return false;
           }
       return true;
    }

    static int[] chk() {
        int[] chkArr = {-1, -1};
        loop:
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 10; j++)
                if(map[i][j] == 1) {
                    chkArr[0] = i; chkArr[1] = j;
                    break loop;
                }
        return chkArr;
    }
}