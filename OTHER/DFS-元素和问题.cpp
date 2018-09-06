/**
给定N个整数（可能有负数），从中选择K个数，使得这K个数之和恰好等于一个
给定的整数X，如果有多种方案，选择他们中元素平方和最大的一个
数据保证这样的方案唯一 
**/ 
#include<vector>
#include<iostream>
using namespace std;
const int maxn = 100010;
//序列A中n个数选k个数使得和为x，最大平方和为maxSumSqu
int n,k,x,maxSumSqu = -1,A[maxn];

//temp存放临时方案，ans存放平方和最大方案
vector<int> temp,ans;

//当前处理index号整数，当前已选整数个数为nowK
//当前已选整数之和为sum，当前已选整数平方和为sumSqu
void dfs(int index,int nowK,int sum,int sumSqu){
	//找到k个数的和为x 
	if(nowK==k&&sum==x){
		//如果比已经找到的更优
		if(sumSqu > maxSumSqu){
			maxSumSqu = sumSqu;//更新最大平方和 
			ans = temp;//更新最优方案 
		} 
		return; 
	}
	
	//已经处理完n个数，或者超过k个数，或者和超过x，返回
	if(index==n||nowK>k||sum>x)
		return;
		
	//选index号数
	temp.push_back(A[index]); 
	//这条分支结束时，就把他从temp中取出，使他不会影响“不选index号数”这条分支 
	dfs(index+1,nowK+1,sum+A[index],sumSqu+A[index]*A[index]);
	temp.pop_back();
	
	//不选index号数
	dfs(index+1,nowK,sum,sumSqu); 
	
}
int main(){
	//序列A中n个数选k个数使得和为x
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
