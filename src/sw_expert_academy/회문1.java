package sw_expert_academy;

import java.util.Scanner;

public class 회문1 {
	public static void main(String[] args) {
		char[][] map = new char[8][8];
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int cnt = sc.nextInt();
			sc.nextLine();
			int ret = 0;
			for(int i = 0; i < 8; i++) {
				String tmp = sc.nextLine();
				for(int j = 0; j < 8; j++)
					map[i][j] = tmp.charAt(j);
			}
			for(int i = 0; i < 8; i++)
				for(int j = 0; j < 8; j++) {
					boolean chk_j = true, chk_i = true;
					int rear_j = j + cnt - 1, rear_i = i + cnt - 1;
					for(int k = j; k < j + cnt / 2; k++, rear_j--)
						if(rear_j >= 8 || map[i][k] != map[i][rear_j]) {
							chk_j = false;
							break;
						}
					for(int k = i; k < i + cnt / 2; k++, rear_i--)
						if(rear_i >= 8 || map[k][j] != map[rear_i][j]) {
							chk_i = false;
							break;
						}
					if(chk_j) ret++;
					if(chk_i) ret++;
				}
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
}
