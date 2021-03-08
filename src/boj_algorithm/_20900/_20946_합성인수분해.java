package boj_algorithm._20900;

import java.util.ArrayList;
import java.util.Scanner;

public class _20946_합성인수분해 {
    static long[] pick;
    static int size = (int) Math.sqrt(Math.pow(10, 12));
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        pick = new long[size + 1];
        if(recur(N)) list.forEach(x -> System.out.print(x + " "));
        else System.out.println(-1);
    }

    static boolean recur(long n) {
        if(isPrime(n)) return false;
        for(int i = 4; i <= Math.sqrt(n); i++) {
            if(isPrime(i)) continue;
            if(n % i == 0) {
                list.add((long)i);
                if(recur(n / i))
                    return true;
                list.remove(list.size() - 1);
            }
        }
        list.add(n);
        return true;
    }

    static boolean isPrime(long number){
        if(number == 2) return true;
        if(number % 2 == 0) return false;

        for(int i=3;i<=Math.sqrt(number);i+=2){
            if(number % i == 0) return false;
        }
        return true;
    }
}
