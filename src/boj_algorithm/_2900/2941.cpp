#include <bits/stdc++.h>
using namespace std;

string croa[8] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

int main() {
	string str; cin >> str;
	int cnt = str.length();
	for(int i=0; i<8; ++i) {
		for(int pos = str.find(croa[i]); pos!=string::npos; pos = str.find(croa[i])) {
			cnt += 1 - croa[i].length();
			str.replace(pos, croa[i].length(), " ");
		}
	}
	cout << cnt << endl;
}

