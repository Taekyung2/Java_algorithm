package sw_expert_academy;

import java.util.Scanner;

public class 지희의_고장난_계산기 {
	static int[] button = new int[10];
	static int fin, ret;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			for(int i = 0; i < 10; i++)
				button[i] = sc.nextInt();
			fin = sc.nextInt();
			ret = Integer.MAX_VALUE;
			dfs(0, 1, 0);
			if (fin == 1 && button[1] == 1) ret = 2;
			System.out.println("#" + t + " " + (ret == Integer.MAX_VALUE ? -1 : ret));
		}
		sc.close();
	}
	
	static void dfs(int cur, int mult, int cnt) {
		if(cnt > ret || mult * cur > fin) return;
		if(mult == fin) ret = cnt;
		
		if(cur != 0 && cur != 1 && fin % cur == 0)
			dfs(0, cur * mult, cnt + 1);
		
		for(int i = 0; i < 10; i++) {
			if(button[i] == 0 || (i == 0 && cur == 0)) continue;
			dfs(cur * 10 + i, mult, cnt + 1);
		}
	}
}
