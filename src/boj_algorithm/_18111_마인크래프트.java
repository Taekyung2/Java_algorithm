package boj_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18111_마인크래프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int result = Integer.MAX_VALUE;
		int height = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] h = new int[257];
		for(int i = 0 ; i < n; i++) {
			String s1 = bf.readLine();
			st = new StringTokenizer(s1);
			for(int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				max = Math.max(max, tmp);
				min = Math.min(min, tmp);
				h[tmp]++;
			}
		}
		
		for(int i = max; i >= min; i--) {
			int ret = 0, bb = b;
			for(int j = max; j > i; j--) {
				ret += h[j] * (j - i) * 2;
				bb += h[j] * (j - i);
			}
			for(int j = i - 1; j >= min; j--) {
				ret += h[j] * (i - j);
				bb -= h[j] * (i - j);
			}
			if(bb < 0) continue;
			if(result > ret) {
				result = ret;
				height = i;
			}
		}
		System.out.println(result + " " + height);
	}
}