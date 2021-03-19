package boj_algorithm._20200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _20299_3대측정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][3];
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int sum = 0;
            boolean chk = true;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] < L)
                    chk = false;
                sum += arr[i][j];
            }
            if(chk && sum >= K) {
                ret.add(arr[i][0]);
                ret.add(arr[i][1]);
                ret.add(arr[i][2]);
            }
        }
        System.out.println(ret.size() / 3);
        for(int a : ret)
            sb.append(a).append(" ");
        System.out.println(sb);
    }
}

