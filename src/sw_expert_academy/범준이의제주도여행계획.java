package sw_expert_academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
 
public class 범준이의제주도여행계획 {
	static class P {
		static int num = 0;
		int no;
		String type;
		int playTime;
		int happy;
		
		public P(String type, int playTime, int happy) {
			this.no = num++;
			this.type = type;
			this.playTime = playTime;
			this.happy = happy;
		}
		
	}
 
    static int N;
    static int M;
    static int[][] map;
    static int[] visited;
    static List<P> list;
    static List<P> load;
    static int[] hotels;
    static int[] plays;
    static List<Integer> resultList;
    static int result;
    static int playNum;
    static int hotelNum;
     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
         
        for (int t = 1; t <= tc; t++) {
            N = in.nextInt();
            M = in.nextInt();
            map = new int[N][N];
            visited = new int[N];
            list = new ArrayList<P>();
            load = new ArrayList<P>();
            hotels = new int[N];
            plays = new int[N];
            playNum = 0;
            hotelNum = 0;
            result = 0;
            P.num = 0;
             
             
            for (int j = 0; j < N-1; j++) {
                for (int k = j+1; k < N; k++) {
                    int tmp = in.nextInt();
                    map[j][k] = tmp;
                    map[k][j] = tmp;
                }
            }
             
            for (int j = 0; j < N; j++) {
                String type = in.next();
                if (("P").equals(type)) {
                    int playTime = in.nextInt();
                    int happy = in.nextInt();
                    P s = new P(type, playTime, happy);
                    plays[playNum++] = j;
                    list.add(s);
                    //noVisitedList.add(s);
                }
                else {
                    P s = new P(type, 0, 0);
                    if (("H").equals(type)){
                        hotels[hotelNum++] = j;
                    }
                    list.add(s);
                }
            }
             
            dfs(0, 0, 0);
             
            System.out.print("#" + t + " " + result);
            if (result > 0) {
                for (Integer no : resultList) {
                    System.out.print(" " + (((int) no) + 1));
                }
            }
            System.out.println();
        }
         
        in.close();
    }
     
    public static void dfs(int index, int time, int happy) {
        if (M == 0) {
            if (result < happy) {
                result = happy;
                resultList = new ArrayList<Integer>();
                for (P s : load) {
                    resultList.add(s.no);
                }
            }
            return;
        }
         
        for (int i = 0; i < playNum; i++) {
            P s = list.get(plays[i]);
            if (visited[s.no] == 1) {
                continue;
            }
            if (time + map[index][s.no] + s.playTime <= 540) {
                visited[s.no] = 1;
                load.add(s);
                dfs(s.no, time + map[index][s.no] + s.playTime, happy+s.happy);
                load.remove(load.size()-1);
                visited[s.no] = 0;
            }
        }
        
        if (M == 1) {
            if (time + map[index][0] > 540) {
                return;
            }
            load.add(list.get(0));
            M--;
            dfs(0, 0, happy);
            load.remove(load.size()-1);
            M++;
        }
        else {
            boolean goHotel = false;
            for (int j = 0; j < hotelNum; j++) {
                P h = list.get(hotels[j]);
                if (time + map[index][h.no] <= 540) {
                    load.add(h);
                    M--;
                    goHotel = true;
                    dfs(h.no, 0, happy);
                    load.remove(load.size()-1);
                    M++;
                    goHotel = false;
                }
            }
            if (!goHotel) {
                return;
            }
        }
         
    }
}