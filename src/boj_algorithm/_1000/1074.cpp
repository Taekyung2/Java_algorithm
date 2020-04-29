#include <bits/stdc++.h>
using namespace std;

int N, r, c;
int cnt = 0;
void find(int curr_r, int curr_c, int curr_n) {
	int range = curr_n / 2;
	if(curr_r == r && curr_c == c) {
		cout << cnt << endl;
		return;
	}
	if(r>=curr_r && r<curr_r+curr_n && c>=curr_c && c<curr_c+curr_n) {	
		find(curr_r, curr_c, range);
		find(curr_r, curr_c+range, range);
		find(curr_r+range, curr_c, range);
		find(curr_r+range, curr_c+range, range);
	}
	else
		cnt += curr_n * curr_n;
}


int main() {
	cin >> N >> r >> c;
	find(0, 0, static_cast<int>(pow(2,N)));
}
