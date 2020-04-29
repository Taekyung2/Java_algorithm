#include <bits/stdc++.h>
using namespace std;

int main() {
    int T; cin >> T;
    while(T--) {
        int from ,to;
        cin >> from >> to;
        long long sum = 0;
        for(int i=1; ; ++i) {
            sum += (i+1) / 2;
            if(sum >= to - from) { 
                cout << i << endl;
                break;
            }
        }
    }
}