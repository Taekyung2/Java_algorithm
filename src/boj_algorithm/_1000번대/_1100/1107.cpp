#include <bits/stdc++.h>
using namespace std;

const int MAX = 505000;
vector<bool> broken(10, true);
int ret, N;


void dfs(string curr) {
	if(curr.length()==6) 
		return;
	for(int i=0; i<10; ++i) 
		if(broken[i]) {
			string next = curr + to_string(i);
			ret = min(ret, abs(N - stoi(next)) + static_cast<int>(next.length()));
			dfs(next);
		}
}

	
int main() {
	int broken_num, broken_button;
	cin >> N >> broken_num;
	for(int i=0; i<broken_num; ++i) {
		cin >> broken_button;
		broken[broken_button] = false;

	}
	ret = abs(100 - N);
	if(broken_num<10)
		dfs("");
	cout << ret << endl;
}
	

