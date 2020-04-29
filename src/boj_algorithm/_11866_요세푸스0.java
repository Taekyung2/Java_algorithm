package boj_algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _11866_요세푸스0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) q.add(i);
		int cnt = 1;
		while(true) {
			while(cnt < k) {
				q.add(q.poll());
				cnt++;
			}
			list.add(q.poll());
			cnt = 1;
			if(q.isEmpty()) break;
		}
		System.out.print("<");
		for(int i = 0; i < list.size(); i++)
			if(i == list.size() - 1) System.out.print(list.get(i));
			else System.out.print(list.get(i) + ", ");
		System.out.print(">");
		sc.close();
	}
}
