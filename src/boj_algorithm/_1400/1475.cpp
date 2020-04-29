#include <bits/stdc++.h>
using namespace std;

vector<int> num(9);
int ret=0, six;
int main() {
	string str; cin >> str;
	for(int i=0; i<str.length(); ++i) {
		if(str[i] == '9') str[i] = '6';
		num[str[i]-'0']++;
	}
	for(int i=0; i<9; ++i) {
		if(num[i]>ret) {
			ret = num[i];
			six = i;
		}
	}
	if(six == 6)	
		cout << (ret+1) / 2 << endl;
	else 
		cout << ret;
}
