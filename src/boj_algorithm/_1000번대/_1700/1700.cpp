#include <bits/stdc++.h>
using namespace std;

int main() {
	// use[i] 현재 i번 구멍에 사용중인 기기번호
	// plan[i] 시간 i에 사용할 기기 번호
	int N, K;
	vector<int> use(100);
	vector<int> plan(100);
	cin >> N >> K;
	for(int i=0; i<K; ++i)
		cin >> plan[i];
	int result = 0;
	for(int i=0; i<K; ++i) {
		//이미 꽂았는지 찾아봄
		bool inUse = false;
		for(int j=0; j<N; ++j) {
			if(plan[i] == use[j]) {
				inUse = true;
				break;
			}
		}
		if(inUse) continue;

		//비어있는 구멍 찾기
		inUse = false;
		for(int j=0; j<N; ++j) {
			if(use[j] == 0) {
				use[j] = plan[i];
				inUse = true;
				break;
			}
		}
		if(inUse) continue;

		// 사용중인 기기 중 가장 나중에 다시 사용할 기기를 쫓아낸다
		int swap, val = -1;
		for(int j=0; j<N; ++j) {
			int term = 0;
			for(int k=i+1; k<K && use[j]!=plan[k]; ++k) term++;
			if(term > val) {
				swap = j;
				val = term;
			}
		}
		result++;
		use[swap] = plan[i];
	}
	cout << result << endl;
	return 0;
}
