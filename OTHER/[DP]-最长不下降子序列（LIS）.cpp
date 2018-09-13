#include<iostream>
#include<algorithm>
using namespace std;
const int N = 100;
int A[N],dp[N];//dp[i]表示以A[i]结尾的最长不下降子序列长度（以A[i]即为是强制的要求） 
int main(){
	int n;
	cin>>n;
	
	for(int i=1;i<=n;i++){
		cin>>A[i];
	}
	
	int ans = -1;//记录最大的dp[i]
	
	for(int i=1;i<=n;i++){//按顺序计算出dp[i]的值  
		dp[i]=1;//边界初始条件（即先假设每个元素自成一个子序列）
		
		//对每一个i，枚举他后面的所有元素 
		for(int j=1;j<i;j++){
			if(A[i]>=A[j] && (dp[j]+1)>dp[i]){
				dp[i] = dp[j] + 1;//状态转移方程，用以更新dp[i] 
			}
		}
		ans = max(ans,dp[i]);
	}

	
	cout<<ans<<endl;
	return 0;
}
