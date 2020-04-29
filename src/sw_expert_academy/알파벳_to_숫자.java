package sw_expert_academy;

import java.util.Scanner;

public class 알파벳_to_숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] arr = new char[str.length()];
		arr = str.toCharArray();
		for(char ch : arr) {
			System.out.print((ch - 'A' + 1) + " ");
		}
		sc.close();
	}
}
