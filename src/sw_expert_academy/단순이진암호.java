package sw_expert_academy;

import java.util.Scanner;

public class 단순이진암호 {
	 public static int code(String str){
	        switch(str){
	        case "0001101" : return 0;
	        case "0011001" : return 1;
	        case "0010011" : return 2;
	        case "0111101" : return 3;
	        case "0100011" : return 4;
	        case "0110001" : return 5;
	        case "0101111" : return 6;
	        case "0111011" : return 7;
	        case "0110111" : return 8;
	        case "0001011" : return 9;
	        }
	        return -1;
	    }
	     
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int tc = sc.nextInt();
	        for(int t = 1; t <= tc; t++) {
	            String key = null;
	            int n = sc.nextInt();
	            sc.nextInt();
	            sc.nextLine();
	            int[] temp = new int[8];
	            for(int i = 0; i < n; i++) {
	                String str = sc.nextLine();
	                if(str.contains("1")) {
	                    for(int j = str.length() - 1; j >= 0; j--){
	                        if(str.charAt(j) == '1') {
	                            key = str.substring(j - 55, j + 1);
	                            break;
	                        }
	                    }
	                }
	            }
	            for(int i = 0; i < 8; i++)
	                temp[i] = code(key.substring(i * 7, (i + 1) * 7));
	            int result = 3 * (temp[0] + temp[2] + temp[4] + temp[6]) + temp[1] + temp[3] + temp[5] + temp[7];
	            if(result % 10 == 0) {
	                result=0;
	                for(int i=0; i<8; i++)
	                    result += temp[i];
	                System.out.println("#" + t + " " + result);
	            }
	            else
	                System.out.println("#" + t + " 0");
	        }
	        sc.close();
	    }
}
