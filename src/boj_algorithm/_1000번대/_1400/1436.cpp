#include <bits/stdc++.h>
using namespace std;


int main() {
	int N;	cin >> N;
	int ret, cnt = 0;
	for(int i=666; ; i++) {
		if(to_string(i).find("666")!=string::npos) cnt++;
		if(cnt==N) {
			cout << i << endl;
			return 0;
		}
	}		
}
