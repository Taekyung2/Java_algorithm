package sw_expert_academy;

import java.util.Scanner;

public class 상원이의_연속합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int num = sc.nextInt();
			int cnt = 0;
			for(int i = 1; i <= num; i++) {
				int tmp = 0;
				for(int j = i; j <= num; j++) {
					tmp += j;
					if(tmp == num) {
						cnt++;
						break;
					}
					if(tmp > num)
						break;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
		sc.close();
	}
}
