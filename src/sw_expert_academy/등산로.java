package sw_expert_academy;

import java.util.Scanner;

public class 등산로 {
    static int n,k;
    static int[][] map;
    static int ret;
    static int[] dx= {0,1,0,-1};
    static int[] dy= {-1,0,1,0};
    
    public static void solve(int x,int y,int now,int num,boolean[][] check,boolean flag) {
        check[y][x]=true;
        for(int i = 0;i < 4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(ny >= 0&& ny < n && nx >= 0 && nx < n) {
                if(!check[ny][nx] && map[ny][nx] < now)               
                    solve(nx,ny,map[ny][nx],num+1,check,flag);
                if(!flag) {
                    for(int j=1;j<=k;j++) {
                        if(!check[ny][nx]&&map[ny][nx]-j<now) {                          
                            solve(nx,ny,map[ny][nx]-j,num+1,check,!flag);
                        }
                    }   
                }
            }
        }
        ret = Math.max(ret, num);
        check[y][x]=false;
    }
    
    public static void main(String[] args) {    
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {         
            n = sc.nextInt();
            k = sc.nextInt();
            int[] x = new int[n*n];
            int[] y = new int[n*n];
            int max=0;
            map = new int[n][n];
            ret = 0;
            for(int i = 0;i < n; i++) {
                for(int j = 0;j < n; j++) {
                    map[i][j] = sc.nextInt();
                    max = Math.max(map[i][j], max);
                }
            }
            int idx=0;
            for(int i = 0;i < n; i++) {
                for(int j = 0;j < n; j++) {                   
                    if(map[i][j] == max) {
                        x[idx] = j;
                        y[idx++] = i;
                    }
                }
            }
            for(int i = 0;i < idx; i++) {
                boolean[][] check = new boolean[n][n];
                solve(x[i] ,y[i],map[y[i]][x[i]],1,check,false);
            }
            System.out.println("#"+ t +" "+ ret);
        }
    }
}