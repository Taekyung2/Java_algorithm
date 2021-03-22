package Line;

import java.util.Arrays;

public class _mun1 {
    class B {
        String name;
        int n;
        B(String name, int n) {
            this.name = name;
            this.n = n;
        }
    }

    public String solution(String[] table, String[] languages, int[] preference) {
        B[] arr = new B[5];
        String[] name = new String[5];
        String[][] score = new String[5][6];
        int i = 0;
        for(String str : table) {
            String[] s = str.split(" ");
            int j = 5;
            name[i] = s[0];
            for(int r = 1; r < s.length; r++)
                score[i][j--] = s[r];
            i++;
        }
        for(int t = 0; t < 5; t++) {
            int sum = 0;
            for(int k = 1; k <= 5; k++) {
                for(int l = 0; l < languages.length; l++) {
                    if(score[t][k].equals(languages[l]))
                        sum += k * preference[l];
                }
            }
            arr[t] = new B(name[t], sum);
        }
        Arrays.sort(arr, (b1 , b2) -> {
            if(b1.n == b2.n) return b1.name.compareTo(b2.name);
            return b2.n - b1.n;
        });
        return arr[0].name;
    }
}