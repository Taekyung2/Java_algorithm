package sw_expert_academy;

import java.util.Scanner;

public class 세로로_말해요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			char[][] board = new char[5][15];
			for(int n = 0; n < 5; n++) {
				String tmp = sc.next();
				for(int i = 0; i < tmp.length(); i++)
					board[n][i] = tmp.charAt(i);
			}
			System.out.print("#" + t + " ");
			for(int i = 0; i < 15; i++)
				for(int j = 0; j < 5; j++)
					if(board[j][i] != 0)
						System.out.print(board[j][i]);
			System.out.println();
		}
		sc.close();
	}
}