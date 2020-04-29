#include <bits/stdc++.h>
using namespace std;

long long sigma(long long n){
	if(n<=0) return 0;
	if(n%2) return (n+1)/2*n;
	else return n/2*(n+1);
}

int main(){
	int T, n, m;
	scanf("%d", &T);
	for(int t=0; t<T; ++t){
		scanf("%d %d", &n, &m);
		printf("Scenario #%d:\n", t+1);
		if(n == m) printf("%d\n",n);
		else if(n >= 0) printf("%lld\n", sigma(m) - sigma(n-1));
		else if(m <= 0) printf("%lld\n", sigma(-m-1) - sigma(-n));
		else printf("%lld\n", sigma(m) - sigma(-n));
		printf("\n");
	}
	return 0;
}

