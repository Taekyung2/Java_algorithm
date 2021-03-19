#include <bits/stdc++.h>
using namespace std;

int main(){
	int N; cin >> N;
	int ret = N + 1;
	for(int i=0; i*3<=N; ++i)
		if((N-(3*i))%5==0)
			ret = min(ret, i+(N-i*3)/5);
	if(ret == N+1)
		ret = -1;
	cout << ret << endl;
}
		
