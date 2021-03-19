#include <bits/stdc++.h>
using namespace std;

int main() {
	int E, S, M;
	scanf("%d %d %d", &E, &S, &M);
	for(int i=1; ; i++) 
		if(!((i-E)%15) && !((i-S)%28) && !((i-M)%19)) {
			cout << i << endl;
			return 0;
		}
}
