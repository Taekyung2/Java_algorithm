package programmers.찾아라프로그래밍마에스터;

import java.util.HashSet;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int n = nums.length / 2;
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums)
            hs.add(num);
        return Math.min(n, hs.size());
    }
}
