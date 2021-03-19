package programmers.summer_winter_coding_2018;

public class 소수만들기 {
    int ret = 0;
    public int solution(int[] nums) {
        solve(nums, 0, 0, 0);
        return ret;
    }

    public void solve(int[] nums, int cur, int cnt, int sum) {
        if(cnt == 3) {
            if(isPrime(sum)) ret++;
            return;
        }
        if(cur == nums.length) return;
        solve(nums, cur + 1, cnt + 1, sum + nums[cur]);
        solve(nums, cur + 1, cnt, sum);
    }

    public boolean isPrime(int num) {
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(int i=3;i<=Math.sqrt(num);i+=2)
            if(num % i == 0) return false;
        return true;
    }
}
