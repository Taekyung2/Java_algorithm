package boj_algorithm;
import java.util.Arrays;
import java.util.Scanner;

public class _15663_NM9 {
	static int N, M, visited = 0;
	static int[] arr, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		result = new int[M];
		for(int i = 0; i < N; i++)
			arr[i] =  sc.nextInt();
		Arrays.sort(arr);
		perm(0);
		sc.close();
	}
	
	public static void perm(int cnt) {
		if(cnt == M) {
			for(int a : result)
				System.out.print(a + " ");
			System.out.println();
			return;
		}
		
		int prev = -1;
		for(int next = 0; next < arr.length; next++) {
			if((visited & 1 << next) != 0 || prev == arr[next]) continue;	
			visited |= (1 << next);
			prev = arr[next];
			result[cnt] = arr[next];
			perm(cnt + 1);
			visited &= ~(1 << next);
		}
	}
}
