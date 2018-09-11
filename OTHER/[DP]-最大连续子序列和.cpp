/**
����һ����������A1,A2,....,An����i,jʹ��Ai+...+Aj������������� 
input
6
-2 11 -4 13 -5 -2
output 
20
**/
#include<iostream>
#include<algorithm>
using namespace std;
const int maxn = 10010; 
int A[maxn],dp[maxn];//A[i]������У�dp[i]�����A[i]��β���������е����� 
int main(){
	int n;
	cin>>n;
	for(int i=0;i<n;i++){//�������� 
		cin>>A[i]; 
	} 
	
	//�߽�
	dp[0] = A[0];
	
	for(int i=1;i<n;i++){
		//״̬ת�Ʒ���
		dp[i] = max(A[i],dp[i-1]+A[i]); 
	} 
	 
	//dp[i]�����A[i]��β���������е����ͣ���Ҫ����i�õ����Ĳ��ǽ��
	int max = 0;
	for(int i=1;i<n;i++){
		if(dp[i]>dp[max]){
			max = i;
		}
	}
	cout<<dp[max]<<endl;
	return 0;
} 
