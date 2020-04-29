package boj_algorithm._1100;

import java.util.Scanner;

public class _1110_더하기사이클 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int cnt = 0;
		if(str.length() == 1)
			str = "0" + str;
		String tmp = str;
		while(true) {
			String front = str.substring(1);
			String rear = Integer.toString((str.charAt(0) - '0') + (str.charAt(1) - '0'));
			if(rear.length() == 1)
				rear = "0" + rear;
			str = front + rear.substring(1);
			cnt++;
			if(tmp.equals(str)) break;
		}
		System.out.println(cnt);
		sc.close();
	}
}
