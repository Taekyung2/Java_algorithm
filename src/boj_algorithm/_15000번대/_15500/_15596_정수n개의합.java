package boj_algorithm._15500;

public class _15596_정수n개의합 {
    long sum(int[] a) {
        long ret = 0;
        for(int n : a)
            ret += n;
        return ret;
    }
}