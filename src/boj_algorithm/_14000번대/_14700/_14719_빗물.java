package boj_algorithm._14000번대._14700;

import java.util.*;

public class _14719_빗물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int w = sc.nextInt();
        List<Integer> map = new ArrayList<>(w);
        for(int i = 0; i < w; i++)
            map.add(sc.nextInt());
        int ret = 0;
        for(int i = 1; i < w; i++) {
            int l = max(map.subList(0, i));
            int r = max(map.subList(i + 1, w));
            int d = Math.min(l, r) - map.get(i);
            if(d > 0) ret += d;
        }
        System.out.println(ret);
    }

    public static int max(List<Integer> map) {
        int max = 0;
        for(int a : map)
            max = Math.max(max, a);
        return max;
    }
}
