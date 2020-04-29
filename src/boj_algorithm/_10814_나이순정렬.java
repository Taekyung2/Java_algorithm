package boj_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class _10814_나이순정렬 {
	static class Human implements Comparable<Human>{
		int idx, age;
		String name;
		
		Human(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Human o) {
			// TODO Auto-generated method stub
			if(this.age == o.age) return this.idx - o.idx;
			return this.age - o.age;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Human[] arr = new Human[n];
		for(int i = 0; i < n; i++)
			arr[i] = new Human(i, sc.nextInt(), sc.next());
		Arrays.sort(arr);
		for(Human a : arr)
			System.out.println(a.age + " " + a.name);
		sc.close();
	}
}
