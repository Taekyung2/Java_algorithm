package ssafy_repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pqExample_1812 {

    static class Rectangle implements Comparable<Rectangle> {
        int min, max;

        public Rectangle(int width, int height) {
            if(width < height) {
                min = width;
                max = height;
            } else {
              min = height;
              max = width;
            }
        }

        @Override
        public int compareTo(Rectangle o) {
            return o.min - this.min;
        }
    }
    static int N, M, size[], cnt;
    static PriorityQueue<Rectangle> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            size = new int[N];
            cnt = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                size[i] = Integer.parseInt(st.nextToken());
            }
            cut();
            sb.append("#" + t + " " + cnt + "\n");
        }
        System.out.println(sb.toString());
    }

    private static void cut() {
        // 가장 큰 크기의 정사각형부터 만들기
        Arrays.sort(size);
        queue = new PriorityQueue<Rectangle>();
        queue.offer(new Rectangle(M, M));
        ++cnt;

        for(int i = N - 1; i >= 0; i--) {
            go(1 << size[i]);
        }
    }

    private static void go(int size) {
        Rectangle r = queue.poll();
        if(r.min >= size) {
            queue.offer(new Rectangle(r.min - size, size));
            queue.offer(new Rectangle(r.min, r.max - size));
        } else {
            queue.offer(r);
            queue.offer(new Rectangle(M - size, size));
            queue.offer(new Rectangle(M, M - size));
            cnt++;
        }
    }
}