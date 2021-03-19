package programmers.월간코드챌린지시즌1;

import java.util.TreeSet;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> hs = new TreeSet<>();
        int n = numbers.length;
        for(int i = 0; i < n - 1; i++)
            for(int j = i + 1; j < n; j++)
                hs.add(numbers[i] + numbers[j]);
        return hs.stream().mapToInt(Integer::intValue).toArray();
    }
}