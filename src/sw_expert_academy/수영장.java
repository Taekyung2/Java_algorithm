package sw_expert_academy;

import java.util.Scanner;

public class 수영장 {
	static int d, m, mmm, min;
	static int[] schedule;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			d = sc.nextInt();
			m = sc.nextInt();
			mmm = sc.nextInt();
			min = sc.nextInt();
			schedule = new int[12];
			for(int d = 0; d < 12; d++)
				schedule[d] = sc.nextInt();
			dfs(0, 0);
			System.out.println("#" + t + " " + min);
		}
		sc.close();
	}
	
	public static void dfs(int lev, int sum) {
		if(sum > min) return;
		if(lev >= 12) {
			min = Math.min(sum, min);
			return;
		}
		if(schedule[lev] == 0) dfs(lev + 1, sum);
		else {
			dfs(lev + 1, sum + d * schedule[lev]);
			dfs(lev + 1, sum + m);
			dfs(lev + 3, sum + mmm);
		}
	}
}