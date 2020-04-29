package sw_expert_academy;

import java.util.Scanner;

public class 사칙연산_유효성_검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int N = sc.nextInt(); sc.nextLine();
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				String str = sc.nextLine();
				String[] tokens = str.split(" ");
				if(tokens.length == 2 && Character.isDigit(tokens[1].charAt(0)))
					cnt++;
			}
			boolean chk = (cnt == N / 2 + 1) ? true : false;
			if(chk) System.out.println("#" + t + " 1");
			else System.out.println("#" + t + " 0");
		}
		sc.close();
	}
}