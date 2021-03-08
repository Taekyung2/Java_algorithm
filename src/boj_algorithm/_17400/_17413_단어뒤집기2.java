package boj_algorithm._17400;

import java.util.*;

public class _17413_단어뒤집기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stk = new ArrayDeque<>();
        boolean chk = false;
        for(char c : s) {
            if(c == '>') {
                chk = false;
                sb.append(c);
                continue;
            }
            if(chk) {
                sb.append(c);
            } else {
                if(c == '<') {
                    while(!stk.isEmpty())
                        sb.append(stk.pollLast());
                     sb.append(c);
                     chk = true;

                } else if(c != ' ') {
                    stk.add(c);
                } else {
                   while(!stk.isEmpty())
                       sb.append(stk.pollLast());
                   sb.append(c);
                }
            }
        }
        while(!stk.isEmpty()) sb.append(stk.pollLast());
        System.out.println(sb);
    }
}
