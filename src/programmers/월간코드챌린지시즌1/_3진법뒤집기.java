package programmers.월간코드챌린지시즌1;

public class _3진법뒤집기 {
    public int solution(int n) {
        String s = Integer.toString(n, 3);
        StringBuilder tmp = new StringBuilder();
        for(int i = s.length() - 1; i >= 0 ; i--)
            tmp.append(s.charAt(i));
        return Integer.parseInt(tmp.toString(), 3);
    }
}