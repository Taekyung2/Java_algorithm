#include <bits/stdc++.h>
using namespace std;

int main() {
	int TC; cin >> TC;
	while(TC--) {
		queue<pair<int,int> > q;
		priority_queue<pair<int,int> > pq;
		int M, N; cin >> N >> M;
		int cnt=1;
		for(int i=0; i<N; ++i) {
			int priority; cin >> priority;
			q.push(make_pair(priority, i));
			pq.push(make_pair(priority, i));
		}
		while(!q.empty()) {
			while(q.front().first < pq.top().first) {	
				q.push(q.front());
				q.pop();
			}
			if(q.front().second == M) {
				cout << cnt << endl;
				break;
			}
			q.pop();
			pq.pop();
			cnt++;
		}
	}
}
		
			
			
			
