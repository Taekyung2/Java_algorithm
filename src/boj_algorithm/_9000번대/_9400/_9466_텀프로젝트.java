package boj_algorithm._9400;

import java.io.*;
import java.util.StringTokenizer;

public class _9466_텀프로젝트 {
    static boolean[] visited, finished;
    static int[] arr;
    static int ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ret = 0;
            visited = new boolean[n];
            finished = new boolean[n];
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken()) - 1;
            for(int i = 0; i < n; i++)
                if(!visited[i]) dfs(i);
            System.out.println(n - ret);
        }
    }

    static void dfs(int cur) {
        if(visited[cur]) {
            finished[cur] = true;
            ret++;
        }
        visited[cur] = true;
        int next = arr[cur];
        if(!finished[next]) dfs(next);
        finished[cur] = true;
    }
}
