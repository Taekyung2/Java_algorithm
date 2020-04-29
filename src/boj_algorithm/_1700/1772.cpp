#include <bits/stdc++.h>
using namespace std;

const int IMPOSSIBLE = 1e9;
vector<int> adj[150];
int n, m, result = IMPOSSIBLE;
int dp[150][151];
void dfs(int curr, int prev) {
	fill(dp[curr], dp[curr]+m+1, IMPOSSIBLE);
	dp[curr][1] = 0;
	for(int next : adj[curr]) {
		if(next == prev) continue;
		dfs(next, curr);
		for(int k=m; k>0; k--) {
			++dp[curr][k];
			for(int i=1; i<k; ++i)
				dp[curr][k] = min(dp[curr][i] + dp[next][k-i], dp[curr][k]);
		}
	}
}


int main()
{
	cin >> n >> m;
	for(int i=0; i<n-1; ++i) {
		int u, v;
		cin >> u >> v;
		u--; v--;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	dfs(0, -1);
	for(int i=0; i<n; ++i)
		result = min(dp[i][m] + (i>0), result);
	cout << result << endl;
	return 0;
}
