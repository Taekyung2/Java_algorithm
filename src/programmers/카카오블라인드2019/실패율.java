package programmers.카카오블라인드2019;

import java.util.ArrayList;
import java.util.List;

public class 실패율 {
    static class P {
        double fail;
        int idx;
        P(double fail, int idx) {
            this.fail = fail;
            this.idx = idx;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] cnt = new int[N + 2], sum = new int[N + 2];
        for(int s : stages) cnt[s]++;
        sum[N + 1] = cnt[N + 1];
        for(int i = N; i >= 1; i--)
            sum[i] = cnt[i] + sum[i + 1];
        List<P> list = new ArrayList<>();
        for(int i = 1; i <= N; i++)
            if(sum[i] == 0) list.add(new P(0, i));
            else list.add(new P((double)cnt[i] / sum[i], i));
        list.sort((p1, p2) -> {
            if (p1.fail == p2.fail) return p1.idx - p2.idx;
            return Double.compare(p2.fail, p1.fail);
        });
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) answer[i] = list.get(i).idx;
        return answer;
    }
}
