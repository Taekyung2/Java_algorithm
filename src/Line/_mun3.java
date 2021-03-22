package Line;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class _mun3 {
    public int[] solution(int[] enter, int[] leave) {
        int size = enter.length;
        int[] answer = new int[size];
        boolean[][] chk = new boolean[size][size];
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for(int i = size - 1; i >= 0; i--)
            stk.add(enter[i]);
        for (int n : leave) {
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            ArrayList<Integer> li = new ArrayList<>();
            int cnt = 0;
            while (!stk.isEmpty() && stk.peekLast() != n) {
                int m = stk.pollLast();
                li.add(m);
                chk[n - 1][m - 1] = true;
                chk[m - 1][n - 1] = true;
                tmp.addLast(m);
                cnt++;
            }
            stk.pollLast();
            for(int i = 0; i < li.size() - 1; i++)
                for(int j = i + 1; j < li.size(); j++) {
                    chk[li.get(i) - 1][li.get(j) - 1] = true;
                    chk[li.get(j) - 1][li.get(i) - 1] = true;
                }
            while (cnt-- > 0)
                stk.addLast(tmp.pollLast());
        }
        for(int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = 0; j < size; j++)
                if(chk[i][j]) sum++;
            answer[i] = sum;
        }
        return answer;
    }
}
