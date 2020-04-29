package sw_expert_academy;

import java.util.ArrayList;
import java.util.Scanner;

public class 비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			String str = sc.next();
			ArrayList<Character> list = new ArrayList<>();
			for(int i = 0; i < N; i++)
				list.add(str.charAt(i));
			while(true) {
				boolean chk = false;
				for(int i = 0; i < list.size() - 1; i++) {
					if(list.get(i) == list.get(i + 1)) {
						list.remove(i);
						list.remove(i);
						chk = true;
						break;
					}
				}
				if(!chk) break;
			}

			System.out.println("#" + t + " ");
			for(int i = 0; i < list.size(); i++)
				System.out.print(list.get(i));
			System.out.println();
		}	
		sc.close();
	}
}
