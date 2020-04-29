package sw_expert_academy;
import java.util.Scanner;

public class 최대상금 {
    static int n, max;
    static String num;
     
    static void swap(int a, int b) {
        char[] tmp = num.toCharArray();
        char ch = tmp[a];
        tmp[a] = tmp[b];
        tmp[b] = ch;
        num = String.valueOf(tmp);
    }

    static void perm(int cur, int cnt) {
        if(cnt == n) {
            max = Math.max(max, Integer.parseInt(num));
            return;
        }
        
        for(int i = cur; i < num.length() - 1; i++) 
            for(int j = i + 1; j < num.length(); j++) {
            	if(num.charAt(i) > num.charAt(j)) continue;
                swap(i, j);
                perm(i, cnt + 1);
                swap(i, j);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc= sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            num = sc.next();
            n = sc.nextInt();
            max = 0;
            perm(0, 0);
            System.out.println("#" + t + " " + max);
        }
        sc.close();
    }
}