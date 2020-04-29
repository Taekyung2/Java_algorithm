package sw_expert_academy;

import java.util.Scanner;

public class 의석이의_우뚝솟은_산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt(), ret = 0, cnt = 0;
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			for(int i = 0; i < n - 1; i++) {					
				if(arr[i] < arr[i + 1]) cnt++;
				else {
					int j = i;
					do { ret += cnt; j++; } while(j < n - 1 && arr[j] > arr[j + 1]);
					cnt = 0;
					i = j - 1;
				}
			}
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
}
