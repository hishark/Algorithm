#include<iostream>
using namespace std;
int main(){
	int n,k;
	cin>>n>>k;
	int broken[101],dp[101];
	for(int i=0;i<k;i++){
		cin>>broken[i];
	}
	int cnt = 0;
	if(broken[cnt]==1){
		dp[1] = 0;
		cnt++;
	}else{
		dp[1] = 1;
	}
	
	if(broken[cnt]==2){
		dp[2] = 0;
		cnt++;
	}else{
		dp[2] = 1 + dp[1];
	}
	
	if(broken[cnt]==3){
		dp[3] = 0;
		cnt++;
	}else{
		dp[3] = dp[1]+dp[2]+1;
	}
	
	for(int i=4;i<=n;i++){
		if(broken[cnt]==i){
			dp[i] = 0;
			cnt++;
		}else{
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
	}
	cout<<dp[n]<<endl;
	return 0;
} 
