#include <bits/stdc++.h>
using namespace std;


int main() {
    int N; cin >> N;
    int cnt = 0, hundred, ten, one;
    if(N<100) {
       cout << N << endl;
       return 0;
    }
    else cnt = 99;
    for(int i=100; i<=N; i++) {
        hundred = i / 100;
        ten     = (i % 100) / 10;
        one     = i % 10; 
        if(hundred - ten == ten - one) 
            cnt++;
    }
    cout << cnt << endl;
    return 0;
}