#include <bits/stdc++.h>
using namespace std;


int main() {
    int N; cin >> N;
    int cnt = 0;
    while(N) {
        cnt += N%2;
        N /= 2;
    }
    cout << cnt << endl;
}