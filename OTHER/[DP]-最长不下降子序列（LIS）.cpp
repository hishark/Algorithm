#include<iostream>
#include<algorithm>
using namespace std;
const int N = 100;
int A[N],dp[N];//dp[i]��ʾ��A[i]��β������½������г��ȣ���A[i]��Ϊ��ǿ�Ƶ�Ҫ�� 
int main(){
	int n;
	cin>>n;
	
	for(int i=1;i<=n;i++){
		cin>>A[i];
	}
	
	int ans = -1;//��¼����dp[i]
	
	for(int i=1;i<=n;i++){//��˳������dp[i]��ֵ  
		dp[i]=1;//�߽��ʼ���������ȼ���ÿ��Ԫ���Գ�һ�������У�
		
		//��ÿһ��i��ö�������������Ԫ�� 
		for(int j=1;j<i;j++){
			if(A[i]>=A[j] && (dp[j]+1)>dp[i]){
				dp[i] = dp[j] + 1;//״̬ת�Ʒ��̣����Ը���dp[i] 
			}
		}
		ans = max(ans,dp[i]);
	}

	
	cout<<ans<<endl;
	return 0;
}
