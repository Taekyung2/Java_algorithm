package boj_algorithm._2400;

import java.util.Scanner;

class pair {
	int dir, len;
	
	public pair(int dir, int len) {
		this.dir = dir;
		this.len = len;
	}
}

public class _2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		pair[] arr = new pair[12];
		int full_square = 0, min_square = 0;
		for(int i = 0; i < 6; i++) { 
			arr[i] = new pair(sc.nextInt(), sc.nextInt());
			arr[i + 6] = arr[i];
		}
		for(int i = 0; i <= 8; i++)
			if(arr[i].dir == arr[i + 2].dir && arr[i + 1].dir == arr[i + 3].dir) {
				full_square = (arr[i].len + arr[i + 2].len) * (arr[i + 1].len + arr[i + 3].len);	
				min_square = arr[i + 1].len * arr[i + 2].len;
				break;
			}
		System.out.println((full_square - min_square) * N);
		sc.close();
	}
}
