package sw_expert_academy;

import java.util.Scanner;

public class 패턴_마디의_길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			String str = sc.next();
			int cnt = 0;
			for(int i = 1; i <= str.length(); i++) 
				if(str.substring(0, i).equals(str.substring(i, 2 * i))) {
					cnt = i;
					break;
				}
			System.out.println("#" + t + " " + cnt);
		}
		sc.close();
	}
}
