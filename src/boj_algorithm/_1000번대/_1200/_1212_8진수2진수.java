package boj_algorithm._1200;

import java.math.BigInteger;
import java.util.Scanner;

public class _1212_8진수2진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new BigInteger(sc.nextLine(), 8).toString(2));
    }
}
