package sw_expert_academy;

import java.util.Scanner;

public class 보호필름 {
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
			
			if(check()) min = 0;
			else {
				copy(tmp, film);
				for(int r = 0; r < 2; r++)
					for(int i = 1; i < (1 << D); i++) {
						backtrack(i, r);
						copy(film, tmp);
					}
			}	
			System.out.println("#" + t + " " + min);
		}
		sc.close();
	}
	
	public static void backtrack(int bit, int val) {
		int cnt = 0, j = 0;
		for(int i = 1; i < (1 << D); i *= 2) {
			if(cnt >= min) return;
			if((i & bit) == i) {
				cnt++;
				for(int k = 0; k < W; k++)
					film[j][k] = val;
			}
			j++;
		}
		if(check())
			min = Math.min(min, cnt);
	}
	
	
	public static void copy(int[][] film, int[][] tmp) {
		for(int i = 0; i < tmp.length; i++)
			film[i] = tmp[i].clone();
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