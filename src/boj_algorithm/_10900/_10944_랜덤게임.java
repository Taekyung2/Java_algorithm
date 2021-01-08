package boj_algorithm._10900;

import java.util.Random;

public class _10944_랜덤게임 {
    public static void main(String[] args) {
        Random rd = new Random();
        int n = rd.nextInt(10000);
        if(n != 0)
            System.out.println(n);
    }
}