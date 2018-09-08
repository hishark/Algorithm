/**
1103 Integer Factorization（30 分）
Sample Input 1:
169 5 2
Sample Output 1:
169 = 6^2 + 6^2 + 6^2 + 6^2 + 5^2
Sample Input 2:
169 167 3
Sample Output 2:
Impossible
**/ 
#include<algorithm>
#include<cmath> 
#include<vector>
#include<iostream>
using namespace std;
int N,K,P,maxfacSum = -1;
vector<int> fac,temp,ans;
//初始化fac数组 
void init(){
	//别忘了让0占个位 
	fac.push_back(0);
	int i=1;
	while(pow(i,P)<=N){
		fac.push_back(pow(i,P));
		i++;
	}
}
/**
找好参数
index为当前序号
nowK为当前已选个数
sum为当前选中的数之和 
facSum为当前选中的底数之和 
**/ 
void dfs(int index, int nowK, int sum, int facSum){
	if(sum==N&&nowK==K){
		if(facSum>maxfacSum){
			maxfacSum = facSum;
			ans = temp;
		}
		return;
	}
	
	if(sum>N||nowK>K)
		return;
	
	if(index>=1){
		temp.push_back(index);
		//"选分支" 
		dfs(index,nowK+1,sum+fac[index],facSum+index);
		
		//不选前记得pop，以免影响"不选分支"
		temp.pop_back();
		dfs(index-1,nowK,sum,facSum); 
	}
}
int main(){
	cin>>N>>K>>P;
	init();
	dfs(fac.size()-1,0,0,0);
	if(maxfacSum==-1){
		cout<<"Impossible"<<endl;
	}else{
		cout<<N<<" = ";
		cout<<ans[0]<<"^"<<P;
		int length = ans.size();
		for(int i=1;i<ans.size();i++){
			cout<<" + "<<ans[i]<<"^"<<P;
		}
	}
	return 0;
}
