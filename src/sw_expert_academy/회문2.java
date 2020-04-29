package sw_expert_academy;

import java.util.Scanner;

public class 회문2 {
	public static void main(String[] args) {
		char[][] map = new char[100][100];
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			sc.nextLine();
			int ret = 0;
			for(int i = 0; i < 100; i++) {
				String tmp = sc.nextLine();
				for(int j = 0; j < 100; j++)
					map[i][j] = tmp.charAt(j);
			}
			for(int i = 0; i < 100; i++)
				for(int j = 0; j < 100; j++) {
					for(int cnt = 2; cnt <= 100; cnt++) {
						boolean chk_j = true, chk_i = true;
						int rear_j = j + cnt - 1, rear_i = i + cnt - 1;
						for(int k = j; k < j + cnt / 2; k++, rear_j--)
							if(rear_j >= 100 || map[i][k] != map[i][rear_j]) {
								chk_j = false;
								break;
							}
						if(chk_j) ret = Math.max(ret, cnt);
						for(int k = i; k < i + cnt / 2; k++, rear_i--)
							if(rear_i >= 100 || map[k][j] != map[rear_i][j]) {
								chk_i = false;
								break;
							}
						if(chk_i) ret = Math.max(ret, cnt);
					}
				}
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
}
