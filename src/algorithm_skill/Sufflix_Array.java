package algorithm_skill;

public class Sufflix_Array {
	static class Comparator {
		int[] group;
		int t;
		
		public Comparator(int[] _group, int _t) {
			group = _group;
			t = _t;
		}
		
		public boolean compareTo(int a, int b) {
			if(group[a] != group[b]) return group[a] < group[b];
			return group[a + t] < group[b + t];
		}
	}
	
	static int[] getSuffixArray(final String s) {
		int n = s.length();
		int t = 1;
		int[] group = new int[n + 1];
		for(int i = 0; i < n; i++) group[i] = s.charAt(i);
		group[n] = -1;
		int[] perm = new int[n];
		for(int i = 0; i < n; i++) perm[i] = i;
		while(t < n) {
			Comparator compareUsing2T = new Comparator(group, t);
			t *= 2;
			if(t >= n) break;
			
			int[] newGroup = new int[n + 1];
			newGroup[n] = -1;
			newGroup[perm[0]] = 0;
			for(int i = 1; i < n; i++)
				if(compareUsing2T.compareTo(perm[i - 1],  perm[i]))
					newGroup[perm[i]] = newGroup[perm[i - 1]] + 1;
				else
					newGroup[perm[i]] = newGroup[perm[i - 1]];
			group = newGroup;
		}
		return perm;
	}
}
