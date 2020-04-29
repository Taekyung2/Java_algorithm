#include <cstdio>
#include <queue>
using namespace std;
const int diry[4] = {-1, 1, 0, 0};
const int dirx[4] = {0, 0, -1, 1};

int main() {
	int T;
	scanf("%d", &T);
	for(int t=0; t<T; ++t) {
		int R, C, sr, sc, er, ec;
		char board[96][96];
		scanf("%d %d\n", &R, &C);
		for(int i=0; i<R; ++i){
			for(int j=0; j<C; ++j){
				board[i][j] = getchar();
				if(board[i][j] == 's') { sr = i; sc = j;}
				if(board[i][j] == 't') { er = i; ec = j;}
			}
			getchar();
		}

		int result = 0;
		bool visited[96][96] = {0};
		visited[sr][sc] = true;
		queue<int> Q;
		Q.push(sr*100 + sc);
		while(!Q.empty()){
			int r = Q.front()/100, c = Q.front()%100; Q.pop();
			if(r == er && c == ec) continue;
			for(int d=0; d<4; ++d) {
				int nr = r+diry[d], nc = c+dirx[d];
				if(nr<0 || nr>=R || nc<0 || nc>=C || board[nr][nc]=='#' || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				Q.push(nr*100 + nc);
				result++;
			}
		}
		printf("%.2lf\n", 1.0*result);
	}
}
