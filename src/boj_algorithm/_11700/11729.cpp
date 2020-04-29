#include <bits/stdc++.h>
using namespace std;


void hanoi(int n, int from, int to) {
	if(n == 0) return;
	int other;
	for(int i=1; i<=3; ++i) 
		if(i!=from && i!=to) other = i;
	hanoi(n-1, from, other);
	printf("%d %d\n", from, to);
	hanoi(n-1, other, to);
}


int main() {
	int N; cin >> N;
	cout << (1<<N)-1 << endl;
	hanoi(N, 1, 3);
}
