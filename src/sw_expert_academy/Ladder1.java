package sw_expert_academy;

import java.util.Scanner;

public class Ladder1 {
	static int[] dx = {-1, 1, 0};
	static int[] dy = {0, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 10; t++) {
			int case_num = sc.nextInt();
			int[][] ladder = new int[100][100];
			int x = 0, y = 0;
			for(int i = 0; i < 100; i++) 
				for(int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
					if(ladder[i][j] == 2) {
						x = j;
						y = i;
					}
				}
			while(y > 0) {
				for(int dir = 0; dir < 3; dir++) {
					int next_x = x + dx[dir];
					int next_y = y + dy[dir];
					if(next_x < 0 || next_y < 0 || next_x >= 100 || next_y >= 100)	continue;
					if(ladder[next_y][next_x] == 1) {
						x = next_x;
						y = next_y;
						ladder[y][x]++;
						break;
					}
				}
			}
			System.out.println("#" + case_num + " " + x);
		}
		sc.close();
	}
}
