package sw_expert_academy;

import java.util.Scanner;

public class 건초더미 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt(), sum = 0, avg = 0, ret = 0;
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			avg = sum / N;
			for(int a : arr) {
				if(avg - a >= 0)
					ret += avg - a;
			}
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
}
