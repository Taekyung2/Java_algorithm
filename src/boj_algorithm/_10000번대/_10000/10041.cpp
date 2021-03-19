#include <bits/stdc++.h>
using namespace std;

struct Point {
	int x;
	int y;
};


int main() {
	int W, H, N;
	int ret = 0;
	cin >> W >> H >> N;
	Point prev;
	cin >> prev.x >> prev.y;
	for(int i=1; i<N; ++i) {
		Point next;
		cin >> next.x >> next.y;
		if(prev.x<next.x&&prev.y<next.y||prev.x>next.x&&prev.y>next.y)
			ret += max(abs(prev.x-next.x), abs(prev.y-next.y));
		else
			ret += abs(prev.x-next.x) + abs(prev.y-next.y);
		prev = {next.x, next.y};
	}
	cout << ret << endl;
	return 0;
}

