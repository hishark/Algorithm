/**
����N�������������и�����������ѡ��K������ʹ����K����֮��ǡ�õ���һ��
����������X������ж��ַ�����ѡ��������Ԫ��ƽ��������һ��
���ݱ�֤�����ķ���Ψһ 
**/ 
#include<vector>
#include<iostream>
using namespace std;
const int maxn = 100010;
//����A��n����ѡk����ʹ�ú�Ϊx�����ƽ����ΪmaxSumSqu
int n,k,x,maxSumSqu = -1,A[maxn];

//temp�����ʱ������ans���ƽ������󷽰�
vector<int> temp,ans;

//��ǰ����index����������ǰ��ѡ��������ΪnowK
//��ǰ��ѡ����֮��Ϊsum����ǰ��ѡ����ƽ����ΪsumSqu
void dfs(int index,int nowK,int sum,int sumSqu){
	//�ҵ�k�����ĺ�Ϊx 
	if(nowK==k&&sum==x){
		//������Ѿ��ҵ��ĸ���
		if(sumSqu > maxSumSqu){
			maxSumSqu = sumSqu;//�������ƽ���� 
			ans = temp;//�������ŷ��� 
		} 
		return; 
	}
	
	//�Ѿ�������n���������߳���k���������ߺͳ���x������
	if(index==n||nowK>k||sum>x)
		return;
		
	//ѡindex����
	temp.push_back(A[index]); 
	//������֧����ʱ���Ͱ�����temp��ȡ����ʹ������Ӱ�조��ѡindex������������֧ 
	dfs(index+1,nowK+1,sum+A[index],sumSqu+A[index]*A[index]);
	temp.pop_back();
	
	//��ѡindex����
	dfs(index+1,nowK,sum,sumSqu); 
	
}
int main(){
	//����A��n����ѡk����ʹ�ú�Ϊx
	cin>>n>>k>>x;
	for(int i=0;i<n;i++){
		cin>>A[i];
	}
	dfs(0,0,0,0);
	int count = ans.size();
	for(int i=0;i<count;i++){
		cout<<ans[i]<<" ";
	}
	return 0;
} 
