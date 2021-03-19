#include <bits/stdc++.h>
using namespace std;

int main() {
	int N, push_cnt=1, pop_cnt=0;
	stack<int> s;
	scanf("%d", &N);
	int poporder[100000];
	vector<char> ret;
	for(int i=0; i<N; ++i)
		scanf("%d", poporder+i);
	while(pop_cnt < N) {
		int target = poporder[pop_cnt];
		if(!s.empty() && s.top() == target) {
			s.pop();
			pop_cnt++;
			ret.push_back('-');
		}
		else if(target < push_cnt) {
			cout << "NO" << endl;
			return 0;
		}
		else {
			s.push(push_cnt++);
			ret.push_back('+');
		}
	}
	for(int i=0; i<ret.size(); ++i)
		printf("%c\n", ret[i]);
}
