#include <bits/stdc++.h>
using namespace std;
const int MAX = 100000;

int uf[MAX];

int find(int n){
	if(uf[n] < 0) return n;
	return uf[n] = find(uf[n]);
}

void merge(int a, int b){
	a = find(a);
	b = find(b);
	if(a == b) return;
	if(uf[a] < uf[b]){
		uf[a] += uf[b];
		uf[b] = a;
	}
	else{
		uf[b] += uf[a];
		uf[a] = b;
	}
}


int main(){
	int TC, N, K, a, b, M, u, v;
	scanf("%d", &TC);
	for(int t=0; t<TC; ++t){
		memset(uf, -1, sizeof(int)*MAX);
		scanf("%d %d", &N, &K);
		for(int i=0; i<K; ++i){
			scanf("%d %d", &a, &b);
			merge(a,b);
		}

		printf("Scenario %d:\n", t+1);
		scanf("%d", &M);
		for(int i=0; i<M; ++i){
			scanf("%d %d", &u, &v);
			if(find(u) == find(v)) puts("1");
			else puts("0");
		}
		if(t < TC-1) puts("");
	}
	return 0;
}
