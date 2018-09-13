/**
Sample Input:
10
-10 1 2 3 4 -5 -23 3 7 -21
Sample Output:先输出最大和，再输出从左到右最先遇到的方案 (1和4是数值而不是下标)
10 1 4
**/
#include<iostream>
#include<algorithm>
using namespace std;
const int maxn = 10010;// 
int a[maxn],dp[maxn];//a[i]存放序列，dp[i]存放以a[i]结尾的连续序列的最大和
int s[maxn] = {0};//s[i]表示产生dp[i]的连续序列从a的哪一个元素开始（即s[i]存的是元素的下标） 
int main(){
	int n;
	cin>>n; 
	bool flag = false;//flag表示数组a中是否全小于0
	for(int i=0;i<n;i++){//读入序列 
		cin>>a[i];
		if(a[i]>=0){
			flag = true;//只要有一个数>=0，flag就记true 
		}
	} 
	
	if(flag == false){//如果a中所有数字都小于0，则输出0以及首尾元素 
		cout<<0<<" "<<a[0]<<" "<<a[n-1]<<endl; 
		//输出之后记得return 
		return 0; 
	}
	
	//边界
	dp[0] = a[0];
	//遍历 
	for(int i=1;i<n;i++){
		if(a[i]+dp[i-1]>a[i]){
			dp[i] = dp[i-1]+a[i];
			s[i] = s[i-1]; 
		}else{
			dp[i] = a[i];
			s[i] = i; 
		}
	}
	
	//找出dp中的最大值 
	int max = 0;
	for(int i=1;i<n;i++){
		if(dp[i]>dp[max]){
			max = i;
		}
	}
	
	cout<<dp[max]<<" "<<a[s[max]]<<" "<<a[max]<<endl;
		
	return 0;
} 
