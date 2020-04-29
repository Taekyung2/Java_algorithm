package sw_expert_academy;

import java.util.Scanner;

public class Magnetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			sc.nextLine();
			int ret = 0;
			int[][] map = new int[100][100];
			for(int i = 0; i < 100; i++)
				for(int j = 0; j < 100; j++)
					map[i][j] = sc.nextInt();
			for(int j = 0; j < 100; j++) {
				int cnt = 0;
				for(int i = 0; i < 100; i++) {
					if(map[i][j] == 2 && cnt == 1) {
						ret++;
						cnt = 0;
					}
					else if(map[i][j] == 1 && cnt == 0) {
						cnt++;
					}
				}
			}
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
}

