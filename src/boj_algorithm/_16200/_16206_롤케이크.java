package boj_algorithm._16200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _16206_롤케이크 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> n1 = new ArrayList<>();
        ArrayList<Integer> n2 = new ArrayList<>();
        int ret = 0;
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            if(a == 10) {
                ret++;
                continue;
            }
            else if(a % 10 == 0) {
                n1.add(a);
            }
            else {
                n2.add(a);
            }
        }
        if(n1.isEmpty() && n2.isEmpty()) {
            System.out.println(ret);
            return;
        }
        Collections.sort(n1);
        Collections.sort(n2);

        for(int i = 0; i < n1.size(); i++) {
            int cur = n1.get(i);
            while(cur != 10) {
                cur -= 10;
                ret++;
                M--;
                if(cur == 10) {
                    ret++;
                }
                if(M == 0) {
                    System.out.println(ret);
                    return;
                }
            }
        }

        for(int i = 0; i < n2.size(); i++) {
            int cur = n2.get(i);
            while(cur > 10) {
                cur -= 10;
                ret++;
                M--;
                if(M == 0) {
                    System.out.println(ret);
                    return;
                }
            }
        }
        System.out.println(ret);
    }
}
