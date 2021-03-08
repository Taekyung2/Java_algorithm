package boj_algorithm._1400;

import java.util.Arrays;
import java.util.Scanner;

public class _1427_소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        Arrays.sort(arr);
        for(int i = arr.length - 1; i >= 0; i--)
            System.out.print(arr[i]);
    }
}