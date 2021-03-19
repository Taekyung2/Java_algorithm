package programmers.카카오블라인드2018;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[n];
        for(int i = 0; i < n; i++) {
            int num = arr1[i] | arr2[i];
            ans[i] = String.format("%" + n + "s", Integer.toBinaryString(num).replace('1', '#').replace('0', ' '));
        }
        return ans;
    }
}