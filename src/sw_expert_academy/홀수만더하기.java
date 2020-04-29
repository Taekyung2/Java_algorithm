package sw_expert_academy;

import java.util.Scanner;

public class 홀수만더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				int tmp = sc.nextInt();
				if(tmp % 2 == 1)
					sum += tmp;
			}
			System.out.println("#" + t + " " + sum);
		}
		sc.close();
	}
}
