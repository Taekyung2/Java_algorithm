package boj_algorithm._1700;

import java.util.Arrays;
import java.util.Scanner;

public class _1759_암호만들기 {
    static int L, C;
    static char[] arr, pick, mo = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new char[C];
        pick = new char[L];
        for(int i = 0; i < C; i++) arr[i] = sc.next().charAt(0);
        Arrays.sort(arr);
        comb(0, 0);
    }

    static void comb(int idx, int cnt) {
        if(cnt == L) {
            int mo_cnt = 0;
            for(int i = 0; i < L; i++)
                for(int j = 0; j < 5; j++)
                    if(pick[i] == mo[j]) {
                        mo_cnt++;
                        break;
                    }
            if(mo_cnt != 0 && mo_cnt < L - 1) System.out.println(pick);
            return;
        }
        for(int i = idx; i < C; i++) {
            pick[cnt] = arr[i];
            comb(i + 1, cnt + 1);
        }
    }
}