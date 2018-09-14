#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std; 
const int N = 100; 
char A[N],B[N];
int dp[N][N];//��dp[i][j]��ʾ�ַ���A��i��λ���ַ���B��j��λ֮ǰ��LCS���ȣ��±��1��ʼ�� 
int main(){
	int n;
	gets(A+1);//���±�Ϊ1��ʼ���� 
	gets(B+1); 
	int lenA = strlen(A+1);//���ڶ���ʱ�±��1��ʼ����˶�ȡ����Ҳ��+1��ʼ
	int lenB = strlen(B+1);
	
	//�߽�
	for(int i=0;i<=lenA;i++){
		dp[i][0] = 0;
	} 
	for(int j=0;j<=lenB;j++){
		dp[0][j] = 0;
	}
	
	//״̬ת�Ʒ���
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
