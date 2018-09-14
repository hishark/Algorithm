#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std; 
const int N = 100; 
char A[N],B[N];
int dp[N][N];//令dp[i][j]表示字符串A的i号位和字符串B的j号位之前的LCS长度（下标从1开始） 
int main(){
	int n;
	gets(A+1);//从下标为1开始读入 
	gets(B+1); 
	int lenA = strlen(A+1);//由于读入时下标从1开始，因此读取长度也从+1开始
	int lenB = strlen(B+1);
	
	//边界
	for(int i=0;i<=lenA;i++){
		dp[i][0] = 0;
	} 
	for(int j=0;j<=lenB;j++){
		dp[0][j] = 0;
	}
	
	//状态转移方程
	for(int i=1;i<=lenA;i++){
		for(int j=1;j<=lenB;j++){
			if(A[i]==B[j]){
				dp[i][j] = dp[i-1][j-1]+1; 
			}else{
				dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
			}
		}
	} 
	
	cout<<dp[lenA][lenB]<<endl;
	return 0;
} 
