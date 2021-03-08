package boj_algorithm._3000;

import java.util.*;

public class _3009_네번째점 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> m1 = new HashMap<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();
        for(int i = 0; i < 3; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            m1.put(x, m1.getOrDefault(x, 0) + 1);
            m2.put(y, m2.getOrDefault(y, 0) + 1);
        }
        for(int a : m1.keySet())
            if(m1.get(a) == 1) System.out.print(a + " ");
        for(int a : m2.keySet())
            if(m2.get(a) == 1) System.out.print(a);

    }
}