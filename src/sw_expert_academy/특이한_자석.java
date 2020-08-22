package sw_expert_academy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 특이한_자석 {
	static int k, ret;
	static int[][] mag = new int[4][8];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			k = sc.nextInt();
			for(int i = 0; i < 4; i++)
				for(int j = 0; j < 8; j++)
					mag[i][j] = sc.nextInt();
			Queue<int[]> q = new LinkedList<>();
			for(int i = 0; i < k; i++) {
				int no = sc.nextInt() - 1;
				int dir = sc.nextInt();
				q.add(new int[]{no, dir});
				int tmp = dir;
				for(int j = no - 1; j >= 0; j--)
					if(mag[j][2] != mag[j + 1][6]) {
						tmp *= -1;
						q.add(new int[] {j, tmp});
					}
					else break;
				tmp = dir;
				for(int j = no + 1; j < 4; j++)
					if(mag[j][6] != mag[j - 1][2]) {
						tmp *= -1;
						q.add(new int[] {j, tmp});
					}
					else break;
				while(!q.isEmpty()) {
					int[] now = q.poll();
					if(now[1] == 1) {
						int tp = mag[now[0]][7];
						for(int j = 6; j >= 0; j--)
							mag[now[0]][j + 1] = mag[now[0]][j];
						mag[now[0]][0] = tp;
					}
					else {
						int tp = mag[now[0]][0];
						for(int j = 1; j < 8; j++)
							mag[now[0]][j - 1] = mag[now[0]][j];
						mag[now[0]][7] = tp;
					
					}
				}
			}
			ret = 0;
			for(int i = 0; i < 4; i++)
				ret += mag[i][0] * Math.pow(2, i);
			System.out.println("#" + t + " " + ret);
		}
	}
}