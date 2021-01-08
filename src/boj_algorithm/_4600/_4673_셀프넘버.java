package boj_algorithm._4600;

public class _4673_셀프넘버 {
    public static void main(String[] args) {
        boolean[] chk = new boolean[10000];
        for(int i = 1; i < 10000; i++) {
            int n = i;
            int sum = i;
            while(true) {
                if(n == 0) break;
                sum += n % 10;
                n /= 10;
            }
            if(sum != i && sum < 10000)
                chk[sum] = true;
        }
        for(int i = 1; i < 10000; i++) {
            if(!chk[i])
                System.out.println(i);
        }
    }
}