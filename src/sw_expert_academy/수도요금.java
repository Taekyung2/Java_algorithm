package sw_expert_academy;
import java.util.Scanner;

public class 수도요금 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] var = new int[5];
		for(int t = 1; t <= tc; t++) {
			for(int i = 0; i < 5; i++)
				var[i] = sc.nextInt();
			int a = var[4] * var[0];
			int b = var[1];
			if(var[4] > var[2])
				b = var[1] + ((var[4] - var[2]) * var[3]);
			int ret = (a >= b) ? b : a;
			System.out.println("#" + t + " " + ret);
		}
		sc.close();
	}
}
