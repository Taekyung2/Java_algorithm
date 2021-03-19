package boj_algorithm._1900;

import java.util.Arrays;
import java.util.Scanner;

public class _1931_회의실배정 {
	public static int N, cnt = 0;
	public static room[] rooms;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		rooms = new room[N];
		for(int i = 0; i < N; i++) 
			rooms[i] = new room(sc.nextInt(), sc.nextInt());
		Arrays.sort(rooms);
		int earliest = 0;
		for(int i = 0; i < N; i++) {
			int meeting_begin = rooms[i].begin;
			int meeting_end = rooms[i].end;
			if(earliest <= meeting_begin) {
				earliest = meeting_end;
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
	
	public static class room implements Comparable<room> {
		int begin, end;
		
		public room(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}
		
		@Override
		public int compareTo(room o) {
			// TODO Auto-generated method stub
			if(this.end == o.end)
				return this.begin - o.begin;
			return this.end - o.end;
		}
	}
}