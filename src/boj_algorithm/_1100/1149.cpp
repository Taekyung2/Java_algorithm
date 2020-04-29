#include <bits/stdc++.h>
using namespace std;

int N;
int cost[3][1000], dp[4][1000];


int sol(int house, int color = 3) {
    int& ret = dp[color][house];
    if(ret != -1) return ret;
    if(house==N) return ret = 0;
    ret = 2e9;
    for(int i=0; i<3; ++i) {
        int next_color = i;
        if(next_color == color) continue;
        ret = min(ret, sol(house+1, next_color) + cost[next_color][house]);
    } 
    return ret;
}


int main() {
    cin >> N;
    for(int i=0; i<N; ++i)
        for(int j=0; j<3; j++)
            cin >> cost[j][i];
    memset(dp, -1, sizeof(dp));
    cout << sol(0) << endl;
}