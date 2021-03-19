package boj_algorithm._1900;

import java.util.Scanner;

public class _1987_알파벳 {
    static int r, c;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static char[][] s;
    static boolean[] chk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt(); c = sc.nextInt();
        s = new char[r][c];
        chk = new boolean[26];
        for(int i = 0; i < r; i++)
            s[i] = sc.next().toCharArray();
        chk[s[0][0] - 'A'] = true;
        System.out.println(dfs(0, 0));
    }

    static int dfs(int y, int x) {
        int ret = 1;
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d], nx = x + dx[d];
            if(ny >= r || nx >= c || ny < 0 || nx < 0 || chk[s[ny][nx] - 'A']) continue;
            chk[s[ny][nx] - 'A'] = true;
            ret = Math.max(ret, dfs(ny, nx) + 1);
            chk[s[ny][nx] - 'A'] = false;
        }
        return ret;
    }
}