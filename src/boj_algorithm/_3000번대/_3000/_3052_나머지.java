package boj_algorithm._3000;

import java.util.Scanner;

public class _3052_나머지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[42];
		for(int i =  0; i < 10; i++)
			arr[sc.nextInt() % 42]++;
		int cnt = 0;
		for(int i = 0; i < arr.length; i++)
			if(arr[i] != 0)
				cnt++;
		System.out.println(cnt);
		sc.close();
	}
}
