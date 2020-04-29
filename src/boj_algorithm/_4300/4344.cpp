#include <bits/stdc++.h>
using namespace std;

int main(){
	int TC;
	scanf("%d", &TC);
	while(TC--) {
		int N, score[1000], sum = 0, cnt = 0;
		scanf("%d", &N);
		for(int i=0; i<N; ++i) {
			scanf("%d", score+i);
			sum += score[i];
		}
		double avr = 1.0 * sum / N; 
		for(int i=0; i<N; ++i) 
			if(avr < score[i]) cnt++;
		printf("%.3f%%\n", 100.0 * cnt / N);
	}
}
