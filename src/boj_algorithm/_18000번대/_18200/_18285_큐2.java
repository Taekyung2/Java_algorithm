package boj_algorithm._18200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _18285_큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String ins = st.nextToken();
            switch (ins) {
                case "push":
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (q.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(q.poll()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if (q.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(q.peekFirst()).append("\n");
                    break;
                case "back":
                    if (q.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(q.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
