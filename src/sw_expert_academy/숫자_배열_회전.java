package sw_expert_academy;

import java.util.Scanner;
public class 숫자_배열_회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int[][][] rotate_map = new int[4][N][N];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					rotate_map[0][i][j] = sc.nextInt();
			for(int i = 1; i <= 3; i++)
				rotate(N, rotate_map[i], rotate_map[i - 1]);
			System.out.println("#" + t);
			for(int i = 0; i < N; i++) {
				for(int k = 1; k <= 3; k++) {
					for(int j = 0; j < N; j++)
						System.out.print(rotate_map[k][i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
	
	static void rotate(int N, int[][] rotate_map, int[][] map) {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				rotate_map[j][N - i - 1] = map[i][j];
	}
}
