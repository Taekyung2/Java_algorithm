package sw_expert_academy;

import java.util.Scanner;
class Tank {
	int dir, y, x;
}

public class 상호의_배틀필드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		char[] dir = {'^', '>', 'v', '<'};
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		for(int t = 1; t <= tc; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			Tank tank = new Tank();
			char[][] map = new char[H][W];
			for(int i = 0; i < H; i++) {
				String str = sc.next();
				for(int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					for(int d = 0; d < 4; d++) {
						if(tank.dir != 0) break;
						if(map[i][j] == dir[d]) {
							map[i][j] = '.';
							tank.dir = d; tank.y = i; tank.x = j;
							break;
						}
					}
				}
			}
			sc.nextInt();
			char[] input = sc.next().toCharArray();
			for(int i = 0; i < input.length; i++) {
				switch(input[i]) {
				case 'U' :
					tank.dir = 0;
					if(tank.y - 1 >= 0 && map[tank.y - 1][tank.x] == '.')
						tank.y--;
					break;
				case 'D' :
					tank.dir = 2;
					if(tank.y + 1 < H && map[tank.y + 1][tank.x] == '.')
						tank.y++;
					break;
				case 'L' :
					tank.dir = 3;
					if(tank.x - 1 >= 0 && map[tank.y][tank.x - 1] == '.')
						tank.x--;
					break;
				case 'R' :
					tank.dir = 1;
					if(tank.x + 1 < W && map[tank.y][tank.x + 1] == '.')
						tank.x++;
					break;
				case 'S' :
					int shoot_y = tank.y, shoot_x = tank.x;
					while(true) {
						if(shoot_y >= H || shoot_x >= W || shoot_y < 0 || shoot_x < 0)
							break;
						else if(map[shoot_y][shoot_x] == '*') {
							map[shoot_y][shoot_x] = '.';
							break;
						}
						else if(map[shoot_y][shoot_x] == '#')
							break;
						shoot_y += dy[tank.dir];
						shoot_x += dx[tank.dir];
					}
					break;
				}
			}
			map[tank.y][tank.x] = dir[tank.dir];
			System.out.print("#" + t + " ");
			for(char[] a : map) {
				for(char b : a)
					System.out.print(b);
				System.out.println();
			}
		}
		sc.close();
	}
}