package programmers.카카오개발자겨울인턴십2019;

import java.util.ArrayDeque;

public class 크레인인형뽑기 {
    public int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        int s = board.length;
        int ret = 0;
        for(int n : moves) {
            n--;
            for(int i = 0; i < s; i++) {
                if(board[i][n] != 0) {
                    if(!stk.isEmpty() && stk.peekLast() == board[i][n]) {
                        ret+=2;
                        stk.pollLast();
                    } else {
                        stk.addLast(board[i][n]);
                    }
                    board[i][n] = 0;
                    break;
                }
            }
        }
        return ret;
    }
}