package boj_algorithm;

import java.util.Scanner;

public class _2920_음계 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		for(int i = 0; i < 8; i++)
			arr[i] = sc.nextInt();
		boolean chk1 = true;
		boolean chk2 = true;
		for(int i = 0; i < 7; i++)
			if(arr[i] + 1 != arr[i + 1]) {
				chk1 = false;
				break;
			}
		for(int i = 0; i < 7; i++)
			if(arr[i] - 1 != arr[i + 1]) {
				chk2 = false;
				break;
			}
		if(!chk1 && !chk2)
			System.out.println("mixed");
		else if(chk1)
			System.out.println("ascending");
		else if(chk2)
			System.out.println("descending");
		sc.close();
	}
}
