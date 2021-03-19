
#include <bits/stdc++.h>
using namespace std;

/*
문자열의 두 번 이상 나오는 부분 문자열 중에 가장 긴 개수 출력
LCP, SUFFIX_ARRAY
*/

string s;
struct Comparator {
	const vector<int>& G;
	int T;

	Comparator(const vector<int>& group, int t) : G(group), T(t) {}

	bool operator() (int a, int b) {
		if(G[a] != G[b])
			return G[a] < G[b];
		return G[a+T] < G[b+T];
	}
};

vector<int> getSuffixArray(const string& s) {
	int n = s.length();
	int t = 1;
	vector<int> group(n+1);
	group[n] = -1;
	for(int i=0; i<n; ++i) group[i] = s[i];
	vector<int> perm(n);
	for(int i=0; i<n; ++i) perm[i] = i;
	while(t < n) {
		Comparator makeSA(group, t);
		sort(perm.begin(), perm.end(), makeSA);
		t*=2;
		if(t >= n) break;
		vector<int> newgroup(n+1);
		newgroup[n] = -1;
		newgroup[perm[0]] = 0;
		for(int i=1; i<n; ++i) 
			if(makeSA(perm[i-1], perm[i]))
				newgroup[perm[i]] = newgroup[perm[i-1]] + 1;
			else
				newgroup[perm[i]] = newgroup[perm[i-1]];
		swap(group, newgroup);
	}
	return perm;
}


vector<int> getLCP(const vector<int>& SA, int n) {
	vector<int> LCP(n);
	vector<int> Rank(n);
	for(int i=0; i<n; ++i)
		Rank[SA[i]] = i;
	int len = 0;
	for(int i=0; i<n; ++i) {
		int k = Rank[i];
		if(k==0) continue;
		int j = SA[k-1];
		while(s[i+len] == s[j+len]) len++;
		LCP[k] = len;
		if(len>0) len--;
	}
	return LCP;
}


int main() {
	cin >> s;
	int n = s.length();
	vector<int> SA = getSuffixArray(s);
	vector<int> LCP = getLCP(SA, n);
	int ret = 0;
	for(int i=0; i<n; ++i)
		ret = max(ret, LCP[i]);
	cout << ret << endl;
	return 0;
}
