package algorithm_skill;

public class KMP_수업 {
	//모든 경우를 다 비교하지 않아도 부분 문자열을 찾을 수 있는 알고리즘
	//접두사와 접미사 개념을 활용해서, 반복되는 연산을 최대한 줄이도록
	//지금까지 검사한 문자열의 접두사와 접미사가 일치하는 최대길이만큼 겹침을 이용
	
	//파이테이블 : 각 길이별로 접두사 == 접미사의 최대길이가 저장된 배열  
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for(int i = 1; i < pattern.length(); i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];
			
			if(pattern.charAt(i) == pattern.charAt(j))
				pi[i] = ++j;	
		}
		return pi;
	}
	
	static boolean KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		int j = 0;
		for(int i = 0; i < origin.length(); i++) {
			while(j > 0 && origin.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];
			
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length() - 1) {
					System.out.println(i - pattern.length() + 1);
					return true;
				}
				else j++;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		String origin = "HELLOSSAFY";
		String pattern = "LOSS";
		KMP(origin, pattern);
	}
}
