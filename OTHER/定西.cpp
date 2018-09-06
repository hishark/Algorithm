#include<iostream> 
using namespace std;
int main() {
	//w-坏了的楼层  dp-每层的走法 
	int n, b, w[101], dp[101], cnt=0;
	cin>>n>>b;
	for(int i=0; i<b; i++)
		cin>>w[i];
	if(w[cnt]==1) {
		//如果第一层坏了，走法为0 
		dp[1]=0;
		//cnt记得自增 
		cnt++;
	} else{
		//第一层的走法显而易见是1 
		dp[1]=1;
	}

	if(w[cnt]==2) {
		dp[2]=0;
		cnt++;
	} else{
		//可以一步跨到第二层，再加上第一层的走法，和即为第二层的总走法。 
		dp[2]=1+dp[1];
	}
		
	if(w[cnt]==3) {
		dp[3]=0;
		cnt++;
	} else{
		//可以一步跨到第三层，所以1。然后再加上第一层和第二层的走法，和即为第三层的总走法。 
		dp[3]=1+dp[1]+dp[2];
	}		

	for(int i=4; i<=n; i++) {
		//如果i号阶梯坏了，那么走法数固定为0 
		if(w[cnt]==i) {
			dp[i]=0;
			cnt++;
		} else{
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
	}
	cout<<dp[n];
	return 0;
}

