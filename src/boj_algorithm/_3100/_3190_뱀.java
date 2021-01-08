package boj_algorithm._3100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class _3190_뱀 {
    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int N, K, L, d = 0, cnt = 0;
    static int[][] map;
    static char[] turn = new char[10001];
    static int[] dy = {0, 1, 0, -1}, dx = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            map[y - 1][x - 1] = 4;
        }
        L = sc.nextInt();
        for (int i = 0; i < L; i++)
            turn[sc.nextInt()] = sc.next().charAt(0);

        Deque<Point> snake = new LinkedList<>();
        snake.add(new Point(0, 0));
        map[0][0] = 1;
        while (true) {
            cnt++;
            Point cur = snake.peekLast();
            Point next = new Point(cur.y + dy[d], cur.x + dx[d]);
            if (next.y < 0 || next.x < 0 || next.y >= N || next.x >= N || map[next.y][next.x] == 1)
                break;
            if (map[next.y][next.x] != 4) {
                Point tail = snake.pollFirst();
                map[tail.y][tail.x] = 0;
            }
            snake.add(next);
            map[next.y][next.x] = 1;
            if((int)turn[cnt] != 0) {
                if(turn[cnt] == 'D') {
                    d++;
                    if(d == 4) d = 0;
                }
                else if(turn[cnt] == 'L') {
                    d--;
                    if(d == -1) d = 3;
                }
            }
        }
        System.out.println(cnt);
    }
}