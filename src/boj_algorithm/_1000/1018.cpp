#include <bits/stdc++.h>
using namespace std;

int main() {
	int M, N;
	string map[50];
	cin >> N >> M;
	for(int i=0; i<N; ++i) {
		string tmp; cin >> tmp;
		map[i] = tmp;	
	}

	int ret = 64;
	for(int i=0; i<=N-8; ++i) {
		for(int j=0; j<=M-8; ++j) {
			int cnt = 0;

			for(int r=0; r<8; ++r)
				for(int c=0; c<8; ++c)
					cnt += (r%2==c%2 ? 'W' : 'B') == map[i+r][j+c];
			ret = min(ret, cnt);
			ret = min(ret, 64-cnt);
		}
	}
	cout << ret << endl;
}
