package sw_expert_academy;

import java.util.Scanner;

public class 불면증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			boolean[] num = new boolean[10];
			int n = sc.nextInt();
			int i = 1;
			int tmp = n;
			while(true) {
				int p = 10, target = 0;
				n = tmp;
				n *= i;
				boolean flag = true;
				while(n != 0) {
					target = n % p;
					num[target] = true;
					n /= p;
				}
				for(boolean j : num)
					if(j == false)
						flag = false;
				if(flag)
					break;
				i++;
			}
			System.out.println("#" + t + " " + i * tmp);
		}
		sc.close();
	}
}
