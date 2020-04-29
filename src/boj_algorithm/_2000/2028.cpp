#include <bits/stdc++.h>
using namespace std;

int main() {
	int T; cin >> T;
	for(int i=0; i<T; ++i) {
		int N; cin >> N;
		int p10 = 1;
		while(p10 <= N) p10 *= 10;
		if(N*N%p10 == N) cout << "YES" <<endl;
		else	cout << "NO" << endl;
	}
	return 0;
}
