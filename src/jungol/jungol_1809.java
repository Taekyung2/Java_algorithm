package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class pair {
	Integer idx;
	Integer height;
	
	public pair(Integer idx, Integer height) {
		this.idx= idx;
		this.height = height;
	}
} 

public class jungol_1809 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		Stack<pair> stk = new Stack<>();
		String[] NM2 = br.readLine().split(" ");
		for(int i = 1; i <= N; i++) {
			pair pr = new pair(i, Integer.parseInt(NM2[i - 1]));
			if(stk.isEmpty()) { 
				stk.push(pr);
				System.out.print("0 ");
			}
			else if(stk.peek().height < pr.height) {
				while(!stk.isEmpty() && stk.peek().height < pr.height) 
					stk.pop();
				if(stk.isEmpty())
					System.out.print("0 ");
				else
					System.out.print(stk.peek().idx + " ");
				stk.push(pr);
			}
			else if(stk.peek().height > pr.height) {
				System.out.print(stk.peek().idx + " ");
				stk.push(pr);
			}
			pr = null;
		}
	}
}
