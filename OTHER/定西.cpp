#include<iostream> 
using namespace std;
int main() {
	//w-���˵�¥��  dp-ÿ����߷� 
	int n, b, w[101], dp[101], cnt=0;
	cin>>n>>b;
	for(int i=0; i<b; i++)
		cin>>w[i];
	if(w[cnt]==1) {
		//�����һ�㻵�ˣ��߷�Ϊ0 
		dp[1]=0;
		//cnt�ǵ����� 
		cnt++;
	} else{
		//��һ����߷��Զ��׼���1 
		dp[1]=1;
	}

	if(w[cnt]==2) {
		dp[2]=0;
		cnt++;
	} else{
		//����һ���絽�ڶ��㣬�ټ��ϵ�һ����߷����ͼ�Ϊ�ڶ�������߷��� 
		dp[2]=1+dp[1];
	}
		
	if(w[cnt]==3) {
		dp[3]=0;
		cnt++;
	} else{
		//����һ���絽�����㣬����1��Ȼ���ټ��ϵ�һ��͵ڶ�����߷����ͼ�Ϊ����������߷��� 
		dp[3]=1+dp[1]+dp[2];
	}		

	for(int i=4; i<=n; i++) {
		//���i�Ž��ݻ��ˣ���ô�߷����̶�Ϊ0 
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

