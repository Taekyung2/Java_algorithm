#include <bits/stdc++.h>
using namespace std;


const int IMPOSSIBLE = 2e9;
int N, M, six[51], single[51], dp[51][101];


int minCost(int pos, int remain) {
	int& ret = dp[pos][remain];
	if(ret != -1) return ret;
	if(remain == 0) return ret = 0;
	if(pos == M) return ret = IMPOSSIBLE;

	ret = min(minCost(pos, max(remain-6, 0)) + six[pos], minCost(pos, remain-1) + single[pos]);
	ret = min(ret, minCost(pos+1, remain));
	return ret;
}

int main() {
	cin >> N >> M;
	for(int i=0; i<M; ++i)
		cin >> six[i] >> single[i];
	memset(dp, -1, sizeof(dp));
	cout << minCost(0,N) << endl;
	return 0;
}