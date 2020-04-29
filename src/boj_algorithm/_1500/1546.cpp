#include <bits/stdc++.h>
using namespace std;

int main() {
	int N; cin >> N;
	double score[1000];
	double sum = 0.0;
	double MAX = 0.0;
	for(int i=0; i<N; ++i) {
		cin >> score[i];
		MAX = max(MAX, score[i]);
	}
	for(int i=0; i<N; ++i) {
		score[i] = score[i] * 100.0 / MAX;
		sum += score[i];
	}
	cout << sum / N << endl;
}
