package boj_algorithm._18100;

import java.util.Scanner;

public class _18119_단어암기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), alpha = (1 << 26) - 1;
        int[] words = new int[n];
        for(int i = 0; i < n; i++) {
            char[] s = sc.next().toCharArray();
            for(char c : s)
                words[i] |= (1 << (c - 'a'));
        }
        for(int i = 0; i < m; i++) {
            int ins = sc.nextInt(), bit = (1 << sc.next().charAt(0) - 'a'), cnt = 0;
            if(ins == 1)
                alpha &= ~bit;
            else
                alpha |= bit;
            for(int w : words)
                if((w & alpha) == w) cnt++;
            System.out.println(cnt);
        }
    }
}