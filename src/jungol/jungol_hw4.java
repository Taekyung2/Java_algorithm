package jungol;

import java.util.Scanner;

public class jungol_hw4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];
		int num = 123456789;
		int i = 0;
		while(true) {
			num = sc.nextInt();
			if(num != -1)
				arr[i++] = num;
			else
				break;
		}
		if(i > 2)
			for(int j = i - 3; j < i; j++)
				System.out.print(arr[j] + " ");
		else
			for(int j = 0; j < i; j++)
				System.out.print(arr[j] + " ");
		sc.close();
	}
}
