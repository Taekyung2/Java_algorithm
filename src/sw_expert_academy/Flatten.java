package sw_expert_academy;

import java.util.Scanner;

public class Flatten {
	static int max, min, max_i, min_i;
	static int[] arr = new int[100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int cnt = sc.nextInt();
			for(int i = 0; i < 100; i++)
				arr[i] = sc.nextInt();
			for(int i = 0; i < cnt; i++) {
				get_max_min();
				arr[max_i]--; arr[min_i]++;
			}
			get_max_min();
			System.out.println("#" + t + " " + (max - min));
		}
		sc.close();
	}
	static void get_max_min() {
		max = 0; min = 100;
		for(int i = 0; i < 100; i++) {
			if(max < arr[i]) {
				max = arr[i];
				max_i = i;
			}
			if(min > arr[i]) {
				min = arr[i];
				min_i = i;
			}
		}
	}
}
