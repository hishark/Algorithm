/**
��һЩ�����ų���������״�����е�һ����һ�����֣��ڶ������������֡�����n����n�����֡�
����Ҫ�ӵ�һ���ߵ���n�㣬ÿ��ֻ��������һ�����ӵ����������е�һ����
�ʣ����·��������������Ӻ�õ��ĺ�����Ƕ��٣� 
���룺
5
5
8 3
12 7 16
4 10 11 6
9 5 3 9 4
�����
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
	//�߽�
	for(int j=1;j<=n;j++){
		dp[n][j] = f[n][j];
	} 
	 
	//�ӵ�n-1�㲻�����ϼ����dp[i][j]
	for(int i=n-1;i>=1;i--){
		//j�����������Լ��� 
		for(int j=1;j<=i;j++){
			//״̬ת�Ʒ���
			dp[i][j] = max(dp[i+1][j],dp[i+1][j+1]) + f[i][j]; 
		}
	} 
	
	cout<<dp[1][1]<<endl;
	return 0;
} 
