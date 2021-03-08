package boj_algorithm._1700;

import java.util.*;

public class _1744_수묶기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> plus = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if(n > 0) plus.add(n);
            else minus.add(n);
        }
        plus.sort(Comparator.reverseOrder());
        Collections.sort(minus);
        int ret = 0;
        for(int i = 1; i < plus.size(); i+=2) {
            int a = plus.get(i - 1), b = plus.get(i);
            if(a == 1 || b == 1) ret += a + b;
            else ret += a * b;
        }
        if(plus.size() % 2 != 0) ret += plus.get(plus.size() - 1);
        for(int i = 1; i < minus.size(); i+=2) {
            int a = minus.get(i - 1), b = minus.get(i);
            ret += a * b;
        }
        if(minus.size() % 2 != 0) ret += minus.get(minus.size() - 1);
        System.out.println(ret);
    }
}