/**
将一些数字排成数塔的形状，其中第一层有一个数字，第二层有两个数字……第n层有n个数字。
现在要从第一层走到第n层，每次只能走向下一层连接的两个数字中的一个。
问：最后将路径上所有数字相加后得到的和最大是多少？ 
输入：
5
5
8 3
12 7 16
4 10 11 6
9 5 3 9 4
输出：
44 
**/ 
#include<iostream>
#include<algorithm>
using namespace std;
const int maxn = 1000;
int f[maxn][maxn],dp[maxn][maxn];
int main(){
	int n;
	cin>>n;
	for(int i=1;i<=n;i++){
		for(int j=1;j<=i;j++){
			cin>>f[i][j];
		}
	}
	//边界
	for(int j=1;j<=n;j++){
		dp[n][j] = f[n][j];
	} 
	 
	//从第n-1层不断往上计算出dp[i][j]
	for(int i=n-1;i>=1;i--){
		//j是自增不是自减啦 
		for(int j=1;j<=i;j++){
			//状态转移方程
			dp[i][j] = max(dp[i+1][j],dp[i+1][j+1]) + f[i][j]; 
		}
	} 
	
	cout<<dp[1][1]<<endl;
	return 0;
} 
