package boj_algorithm._15600;

import java.util.*;

public class _15666_N과M12 {
    static int N, M;
    static HashSet<Integer> s = new HashSet<>();
    static int[] pick;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        pick = new int[M];
        for(int i = 0; i < N; i++)
            s.add(sc.nextInt());
        list = new ArrayList<>(s);
        Collections.sort(list);
        perm(0, 0);
    }

    static void perm(int idx, int cnt) {
        if(cnt == M) {
            for(int n : pick)
                System.out.print(n + " ");
            System.out.println();
            return;
        }
        for(int i = idx; i < list.size(); i++) {
            pick[cnt] = list.get(i);
            perm(i, cnt + 1);
        }
    }
}
