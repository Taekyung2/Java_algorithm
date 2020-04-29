package boj_algorithm._1100;

import java.util.Scanner;

public class _1152_단어의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();
		String[] arr = str.split(" ");
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) 
			if(!arr[i].equals(""))
				cnt++;
		System.out.println(cnt);
		sc.close();
	}
}
