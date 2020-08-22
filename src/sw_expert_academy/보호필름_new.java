package sw_expert_academy;

import java.util.Arrays;
import java.util.Scanner;

public class 보호필름_new {
	static int D, W, K, min;
	static int[][] film, tmp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			D 		= sc.nextInt();
			W 		= sc.nextInt();
			K 		= sc.nextInt();
			min 	= K;
			film 	= new int[D][W];
			tmp 	= new int[D][W];
			for(int i = 0; i < D; i++) 
				for(int j = 0; j < W; j++)
					film[i][j] = sc.nextInt();
			dfs(0, 0);
			System.out.println("#" + t + " "+ min);
		}
		sc.close();
	}

	public static void dfs(int d, int cnt) {
		if(cnt > min) return;
		if(d == D) {
			if(check()) min = Math.min(cnt, min);
			return;
		}
		dfs(d + 1, cnt);
		for(int ab = 0; ab < 2; ab++) {
			tmp[d] = film[d].clone();
			Arrays.fill(film[d], ab);
			dfs(d + 1 , cnt + 1);
			film[d] = tmp[d].clone();
		}
	}
	
	public static boolean check() {
		for(int i = 0; i < W; i++) {
			int cnt = 1;
			boolean chk = false;
			for(int j = 0; j < D - 1; j++) {
				if(film[j][i] == film[j + 1][i]) cnt++;
				else cnt = 1;
				
				if(cnt >= K) { 
					chk = true; 
					break; 
				}
			}	
			if(!chk) return false;
		}
		return true;
	}
}	