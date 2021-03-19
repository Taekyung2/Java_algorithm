package boj_algorithm._1600;

import java.io.*;
import java.util.*;

public class _1655_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if (minH.size() == maxH.size()) maxH.add(m);
            else minH.add(m);
            if(!minH.isEmpty() && !maxH.isEmpty() && minH.peek() < maxH.peek()) {
                int a = minH.poll();
                int b = maxH.poll();
                minH.add(b);
                maxH.add(a);
            }
            sb.append(maxH.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
