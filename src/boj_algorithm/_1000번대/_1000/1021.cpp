#include <bits/stdc++.h>
using namespace std;

int main() {
    int N, M;
    int ret = 0;
    cin >> N >> M;
    vector<int> target(M);
    for(int i=0; i<M; ++i) 
        cin >> target[i];
    deque<int> dq(N);
    for(int i=1; i<=N; ++i)
        dq[i-1] = i;
    for(int i=0; i<M; ++i) {
        int pos = find(dq.begin(), dq.end(), target[i]) - dq.begin();
        int left = pos;
        int right = dq.size() - pos;
        if(left > right) { 
            while(right--) {
                dq.push_front(dq.back());
                dq.pop_back();
                ret++;
            }
            dq.pop_front();
        }
        else {
            while(left--) {
                dq.push_back(dq.front());
                dq.pop_front();
                ret++;
            }
            dq.pop_front();
        }
    }
    cout << ret << endl;
}