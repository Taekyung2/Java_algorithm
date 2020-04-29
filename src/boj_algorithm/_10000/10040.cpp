#include <bits/stdc++.h>
using namespace std;
const int MAX = 1000;

int main() {
	int N, M;
	vector<int> A(MAX), B(MAX), cnt(MAX,0);
	cin >> N >> M;
	for(int i=0; i<N; ++i)
		cin >> A[i];
	for(int i=0; i<M; ++i) {
		cin >> B[i];
		for(int j=0; j<N; ++j) {
			if(A[j] > B[i])
				continue;
			++cnt[j];
			break;
		}
	}

	int ret = 0;
	for(int i=0; i<N; ++i)
		if(cnt[ret] < cnt[i])
			ret = i;
	cout << ret + 1 << endl;
	return 0;
}
