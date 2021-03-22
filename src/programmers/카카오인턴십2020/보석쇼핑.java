package programmers.카카오인턴십2020;

import java.util.*;

public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>(Arrays.asList(gems));
        Queue<String> q = new LinkedList<>();
        int idx = 1, s = 0, ret = Integer.MAX_VALUE;
        for(String gem : gems) {
            hm.put(gem, hm.getOrDefault(gem, 0) + 1);
            q.add(gem);
            while(hm.get(q.peek()) > 1) {
                String st = q.poll();
                hm.put(st, hm.get(st) - 1);
                idx++;
            }
            if(hm.size() == hs.size() && ret > q.size() - 1) {
                s = idx;
                ret = q.size() - 1;
            }
        }
        return new int[]{s, s + ret};
    }
}