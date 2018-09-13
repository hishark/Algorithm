/**
Sample Input:
10
-10 1 2 3 4 -5 -23 3 7 -21
Sample Output:��������ͣ���������������������ķ��� (1��4����ֵ�������±�)
10 1 4
**/
#include<iostream>
#include<algorithm>
using namespace std;
const int maxn = 10010;// 
int a[maxn],dp[maxn];//a[i]������У�dp[i]�����a[i]��β���������е�����
int s[maxn] = {0};//s[i]��ʾ����dp[i]���������д�a����һ��Ԫ�ؿ�ʼ����s[i]�����Ԫ�ص��±꣩ 
int main(){
	int n;
	cin>>n; 
	bool flag = false;//flag��ʾ����a���Ƿ�ȫС��0
	for(int i=0;i<n;i++){//�������� 
		cin>>a[i];
		if(a[i]>=0){
			flag = true;//ֻҪ��һ����>=0��flag�ͼ�true 
		}
	} 
	
	if(flag == false){//���a���������ֶ�С��0�������0�Լ���βԪ�� 
		cout<<0<<" "<<a[0]<<" "<<a[n-1]<<endl; 
		//���֮��ǵ�return 
		return 0; 
	}
	
	//�߽�
	dp[0] = a[0];
	//���� 
	for(int i=1;i<n;i++){
		if(a[i]+dp[i-1]>a[i]){
			dp[i] = dp[i-1]+a[i];
			s[i] = s[i-1]; 
		}else{
			dp[i] = a[i];
			s[i] = i; 
		}
	}
	
	//�ҳ�dp�е����ֵ 
	int max = 0;
	for(int i=1;i<n;i++){
		if(dp[i]>dp[max]){
			max = i;
		}
	}
	
	cout<<dp[max]<<" "<<a[s[max]]<<" "<<a[max]<<endl;
		
	return 0;
} 
