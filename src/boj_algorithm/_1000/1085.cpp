#include <bits/stdc++.h>
using namespace std;


int main() {
    int x, y, w, h;
    cin >> x >> y >> w >> h;
    int ret = min(x, min(y, min(w-x, h-y)));
    cout << ret << endl;
}