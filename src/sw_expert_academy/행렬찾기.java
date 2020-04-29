package sw_expert_academy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class matrix implements Comparable<matrix>{
	int size, col, row;
	
	public matrix(int size, int col, int row) {
		this.size = size;
		this.col = col;
		this.row = row;
	}
	
	@Override
	public int compareTo(matrix m) {
		if(this.size == m.size) return (int)(this.col - m.col);
		return (int)(this.size - m.size);
	}
}

public class 행렬찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			ArrayList<matrix> list = new ArrayList<>();
			int[][] arr = new int[N + 1][N + 1];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			int start_x = -1, start_y = -1;
			for(int i = 0; i < N; i++) 
				for(int j = 0 ; j < N; j++) {
					if(arr[i][j] != 0) {
						start_x = j;
						start_y = i;
						while(arr[start_y][start_x + 1] != 0) start_x++;
						while(arr[start_y + 1][start_x] != 0) start_y++;
						list.add(new matrix((start_y  - i + 1) * (start_x  - j + 1), start_y  - i + 1, start_x  - j + 1));
						for(int m = i; m <= start_y; m++)
							for(int n = j; n <= start_x; n++)
								arr[m][n] = 0;
					}
				}
			Collections.sort(list);
			System.out.print("#" + t + " " + list.size() + " ");
			for(int i = 0; i < list.size(); i++)
				System.out.print(list.get(i).col + " " + list.get(i).row + " ");
			System.out.println();
		}
		sc.close();
	}
}