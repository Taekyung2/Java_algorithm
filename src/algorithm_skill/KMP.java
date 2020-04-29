package algorithm_skill;

import java.util.ArrayList;

public class KMP {
	
	ArrayList<Integer> getPartialMatch(final String N) {
		int m = N.length();
		ArrayList<Integer> pi = new ArrayList<>(m);
		//kmp로 자기 자신을 찾는다
		int begin = 1, matched = 0;
		while(begin + matched < m) {
			if(N.charAt(begin + matched) == N.charAt(matched)) {
				++matched;
				pi.set(begin + matched - 1,  matched);
			}
			else {
				if(matched == 0) ++begin;
				else {
					begin += matched - pi.get(matched - 1);
					matched = pi.get(matched - 1);
				}
			}
		}
		return pi;
	}
	
	ArrayList<Integer> kmpSearch(final String H, final String N) {
		int n = H.length(), m = N.length();
		ArrayList<Integer> ret = new ArrayList<>();
		ArrayList<Integer> pi = getPartialMatch(N);	
		int matched = 0;
		
		for(int i = 0; i < n; i++) {
			while(matched > 0 && H.charAt(i) != N.charAt(matched)) {
				matched = pi.get(matched - 1);
				
				//글자가 대응될 경우
				if(H.charAt(i) == N.charAt(matched)) {
					++matched;
					if(matched == m) {
						ret.add(i - m + 1);
						matched = pi.get(matched - 1);
					}
				}
			}
		}
		return ret;
	}
}
