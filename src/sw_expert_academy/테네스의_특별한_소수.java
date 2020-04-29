package sw_expert_academy;

import java.util.Scanner;

public class 테네스의_특별한_소수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			boolean[] arr = new boolean[1000001];
			arr[1] = true;
			int d = sc.nextInt();
			int a = sc.nextInt();
			int b=  sc.nextInt();
			int cnt = 0;
			for(int i = 2; i <= Math.sqrt(b); i++) {
				if(arr[i] == false) {	
					for(int j = i * i; j <= b; j += i)
						arr[j] = true;
				}
			}
			for(int i = a; i <= b; i++) {
				if(arr[i] == false) {
					if(Integer.toString(i).contains(d + ""))
						cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
		sc.close();
	}
}
