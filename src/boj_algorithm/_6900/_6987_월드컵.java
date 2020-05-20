package boj_algorithm._6900;

import java.util.Scanner;

public class _6987_월드컵 {
    static int ret;
    static int[][] score = new int[6][3];
    static int[][] games = new int[6][3];
    static int[][] play = new int[15][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0, k = 0; i < 5; i++)
            for(int j = i + 1; j < 6; j++, k++) {
               play[k][0] = i;
               play[k][1] = j; 
            }
        
        for(int i = 0; i < 4; i++) {
            ret = 0;
            for(int j = 0; j < 6; j++) {
                for(int r = 0; r < 3; r++) {
                    score[j][r] = sc.nextInt();
                    games[j][r] = 0;
                }
            }

            backtrack(0);
            System.out.print(ret + " ");
        }
    }

    public static void backtrack(int cur) {
        if(cur == 15) {
            for(int i = 0; i < 6; i++)
                for(int j = 0; j < 3; j++)
                    if(score[i][j] != games[i][j])
                        return;
            ret = 1;
            return;
        }
        
        int a = play[cur][0];
        int b = play[cur][1];
        
        games[a][0]++; games[b][2]++;
        backtrack(cur + 1);
        games[a][0]--; games[b][2]--;
        
        games[a][2]++; games[b][0]++;
        backtrack(cur + 1);
        games[a][2]--; games[b][0]--;

        games[a][1]++; games[b][1]++;
        backtrack(cur + 1);
        games[a][1]--; games[b][1]--;
    }
}