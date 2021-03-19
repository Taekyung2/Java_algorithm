package programmers.카카오인턴십2020;

public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[][] button = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        int[] L = {3, 0}, R = {3, 2};
        for(int num : numbers) {
            int[] next = button[num];
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                L = next;
            } else if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                R = next;
            } else {
                int ld = Math.abs(next[0] - L[0]) + Math.abs(next[1] - L[1]);
                int rd = Math.abs(next[0] - R[0]) + Math.abs(next[1] - R[1]);
                if(ld == rd) {
                    if(hand.equals("right")) {
                        sb.append("R");
                        R = next;
                    }
                    else {
                        sb.append("L");
                        L = next;
                    }
                } else if(ld > rd) {
                    sb.append("R");
                    R = next;
                } else {
                    sb.append("L");
                    L = next;
                }
            }
        }
        return sb.toString();
    }
}