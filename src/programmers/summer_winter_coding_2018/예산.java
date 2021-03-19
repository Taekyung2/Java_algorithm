package programmers.summer_winter_coding_2018;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int ret = 0, idx = 0;
        while(idx < d.length) {
            budget -= d[idx++];
            if(budget >= 0) ret++;
            else break;
        }
        return ret;
    }
}
